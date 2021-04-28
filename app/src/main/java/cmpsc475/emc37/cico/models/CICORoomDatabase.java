package cmpsc475.emc37.cico.models;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = Entry.class, version = 1, exportSchema = false)
public abstract class CICORoomDatabase extends RoomDatabase {
  public abstract EntryDAO entryDAO();

  private static volatile CICORoomDatabase INSTANCE;
  private static final int NUMBER_OF_THREADS = 4;
  static final ExecutorService databaseWriteExecutor =
      Executors.newFixedThreadPool(NUMBER_OF_THREADS);

  public static CICORoomDatabase getDatabase(final Context context) {
    if (INSTANCE == null) {
      synchronized (CICORoomDatabase.class) {
        if (INSTANCE == null) {
          INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                          CICORoomDatabase.class,
                                          "cico_database")
                         .build();
        }
      }
    }
    return INSTANCE;
  }

  public static ExecutorService getDatabaseWriteExecutor() {
    return databaseWriteExecutor;
  }
}
