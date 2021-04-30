package cmpsc475.emc37.cico.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import cmpsc475.emc37.cico.models.SearchResultDTO;
import cmpsc475.emc37.cico.ui.main.FoodItemAdapter;

public class SearchResultViewModel extends AndroidViewModel {
  private LiveData<List<SearchResultDTO>> results;
  private FoodItemAdapter foodItemAdapter;

  public SearchResultViewModel(@NonNull Application application) {
    super(application);
    results = new MutableLiveData<>(new ArrayList<>());
  }

  public LiveData<List<SearchResultDTO>> getResults() {
    return results;
  }

  public void setFoodItemAdapter(FoodItemAdapter foodItemAdapter) {
      this.foodItemAdapter = foodItemAdapter;
  }

  public FoodItemAdapter getFoodItemAdapter() {
    return foodItemAdapter;
  }
}
