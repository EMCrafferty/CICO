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



  public LiveData<List<SearchResultDTO>> getResults() {
    return results;
  }
}
