package cmpsc475.emc37.cico.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import cmpsc475.emc37.cico.models.Entry;
import cmpsc475.emc37.cico.services.CICORepository;
import cmpsc475.emc37.cico.ui.main.FoodItemEntryAdapter;

public class EntryViewModel extends AndroidViewModel {
  private final CICORepository repository;
  private final LiveData<List<Entry>> allEntries;
  private FoodItemEntryAdapter entryAdapter;

  public EntryViewModel(@NonNull Application application) {
    super(application);
    repository = new CICORepository(application);
    allEntries = repository.getAllEntries();
  }

  public LiveData<List<Entry>> getAllEntries() {
    return allEntries;
  }

  public void insert(Entry entry) {
    repository.insert(entry);
  }

  public void deleteAllEntries() {
    repository.deleteAllEntries();
  }

  public FoodItemEntryAdapter getEntryAdapter() {
    return entryAdapter;
  }

  public void setEntryAdapter(FoodItemEntryAdapter entryAdapter) {
    this.entryAdapter = entryAdapter;
  }
}
