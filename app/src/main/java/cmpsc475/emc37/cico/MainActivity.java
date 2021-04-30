package cmpsc475.emc37.cico;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cmpsc475.emc37.cico.models.Entry;
import cmpsc475.emc37.cico.models.SearchResultDTO;
import cmpsc475.emc37.cico.models.SearchResultPOJO;
import cmpsc475.emc37.cico.services.CICORepository;
import cmpsc475.emc37.cico.services.FDCService;
import cmpsc475.emc37.cico.services.IFDCService;
import cmpsc475.emc37.cico.ui.main.FoodItemAdapter;
import cmpsc475.emc37.cico.ui.main.SectionsPagerAdapter;
import cmpsc475.emc37.cico.viewmodels.EntryViewModel;
import cmpsc475.emc37.cico.viewmodels.SearchResultViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
  private EntryViewModel entryViewModel;
  private SearchResultViewModel searchResultViewModel;

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this,
                                                                         getSupportFragmentManager());
    ViewPager viewPager = findViewById(R.id.view_pager);
    viewPager.setAdapter(sectionsPagerAdapter);
    TabLayout tabs = findViewById(R.id.tabs);
    tabs.setupWithViewPager(viewPager);

    //

    // VIEWMODEL TESTING:
    entryViewModel = new ViewModelProvider(
        this,
        ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(
        EntryViewModel.class);

    searchResultViewModel = new ViewModelProvider(
        this,
        ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(
        SearchResultViewModel.class);

    viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

      }

      @Override
      public void onPageSelected(int position) {
        Log.d("viewPager", "onPageSelected: " + position + "\n");

        switch (position) {
          case 0:
            Log.d("viewPager", "Log Fragment");

            break;
          case 1:
            Log.d("viewPager", "Search Fragment");
            RecyclerView searchResultRecyclerView = findViewById(R.id.searchResultRecyclerView);
            final FoodItemAdapter foodItemAdapter = new FoodItemAdapter();
            searchResultRecyclerView.setAdapter(foodItemAdapter);
            searchResultRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            searchResultRecyclerView.setHasFixedSize(true);


            searchResultViewModel.searchFood("celery");
            searchResultViewModel.getResults().observe(MainActivity.this, foodItemAdapter::setItems);

            break;
          case 2:
            Log.d("viewPager", "Data Fragment");
            break;
        }

      }

      @Override
      public void onPageScrollStateChanged(int state) {

      }
    });



  }

}