package cmpsc475.emc37.cico.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import cmpsc475.emc37.cico.models.SearchResultDTO;
import cmpsc475.emc37.cico.models.SearchResultPOJO;
import cmpsc475.emc37.cico.services.FDCService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResultViewModel extends AndroidViewModel {
  private LiveData<List<SearchResultDTO>> results;

  public SearchResultViewModel(@NonNull Application application) {
    super(application);
    results = new MutableLiveData<>(new ArrayList<>());
  }

  public void searchFood(String food) {
    FDCService.searchFood(food).enqueue(new Callback<SearchResultPOJO>() {
      @Override
      public void onResponse(@NotNull Call<SearchResultPOJO> call, @NotNull Response<SearchResultPOJO> response) {
        Log.d("searchFood", "SUCCESS");
        results.getValue().clear();
        results.getValue().addAll(SearchResultDTO.parsePOJO(response.body()));

      }

      @Override
      public void onFailure(@NotNull Call<SearchResultPOJO> call, @NotNull Throwable t) {
        Log.d("searchFood", "FAILURE");
        Log.d("searchFood", call.request().toString());
      }
    });
  }

  public LiveData<List<SearchResultDTO>> getResults() {
    return results;
  }
}
