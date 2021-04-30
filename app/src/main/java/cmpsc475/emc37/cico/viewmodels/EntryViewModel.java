package cmpsc475.emc37.cico.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import cmpsc475.emc37.cico.models.Entry;
import cmpsc475.emc37.cico.services.CICORepository;

public class EntryViewModel extends AndroidViewModel {
  private final CICORepository mRepository;
  private final LiveData<List<Entry>> mAllEntries;

  public EntryViewModel(@NonNull Application application) {
    super(application);
    mRepository = new CICORepository(application);
    mAllEntries = mRepository.getAllEntries();
  }

  public LiveData<List<Entry>> getAllEntries() {
    return mAllEntries;
  }

  public void insert(Entry entry) {
    mRepository.insert(entry);
  }

  public void deleteAllEntries() {
    mRepository.deleteAllEntries();
  }
}
