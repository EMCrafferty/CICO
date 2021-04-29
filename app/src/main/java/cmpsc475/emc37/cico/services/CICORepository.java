package cmpsc475.emc37.cico.services;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;

import cmpsc475.emc37.cico.models.CICORoomDatabase;
import cmpsc475.emc37.cico.models.Entry;
import cmpsc475.emc37.cico.models.EntryDAO;

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
}
