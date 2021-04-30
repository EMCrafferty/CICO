package cmpsc475.emc37.cico.services;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import cmpsc475.emc37.cico.models.CICORoomDatabase;
import cmpsc475.emc37.cico.models.Entry;
import cmpsc475.emc37.cico.models.EntryDAO;
import cmpsc475.emc37.cico.models.SearchResultDTO;
import cmpsc475.emc37.cico.models.SearchResultPOJO;
import cmpsc475.emc37.cico.ui.main.FoodItemAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CICORepository {
  private final EntryDAO mEntryDAO;
  private final LiveData<List<Entry>> mAllEntries;
  private final ExecutorService dbWrEx = CICORoomDatabase.getDatabaseWriteExecutor();

  public CICORepository(Application application) {
    CICORoomDatabase db = CICORoomDatabase.getDatabase(application);

    this.mEntryDAO = db.entryDAO();
    this.mAllEntries = mEntryDAO.getEntriesByTime();
  }

  public LiveData<List<Entry>> getAllEntries() {
    return mAllEntries;
  }

  public void deleteAllEntries() {
    dbWrEx.submit(mEntryDAO::deleteAll);
  }

  public void insert(Entry entry) {
    dbWrEx.execute(() -> mEntryDAO.insert(entry));
  }

  public static void searchFood(String food, FoodItemAdapter adapter) {
    FDCService.searchFood(food).enqueue(new Callback<SearchResultPOJO>() {
      @Override
      public void onResponse(@NotNull Call<SearchResultPOJO> call, @NotNull Response<SearchResultPOJO> response) {
        Log.d("searchFood", "SUCCESS");
        adapter.setItems(SearchResultDTO.parsePOJO(response.body()));

      }

      @Override
      public void onFailure(@NotNull Call<SearchResultPOJO> call, @NotNull Throwable t) {
        Log.d("searchFood", "FAILURE");
        Log.d("searchFood", call.request().toString());
      }
    });
  }
}