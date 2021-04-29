package cmpsc475.emc37.cico;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
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
import cmpsc475.emc37.cico.ui.main.SectionsPagerAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

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

    // ROOM TESTING:
    CICORepository repo = new CICORepository(getApplication());
    repo.getAllEntries()
        .observe(this, entries -> entries.forEach(e -> Log.d("ROOM", ".\n" + e.toString())));
    repo.deleteAllEntries();
    repo.insert(
        new Entry(
            420,
            Arrays.asList(
                new Entry.Food("Egg", 280, 4.0),
                new Entry.Food("Egg", 140, 2.0)
            ),
            OffsetDateTime.now())
    );



    // RETROFIT TESTING:

//    Retrofit retrofit = new Retrofit.Builder()
//        .baseUrl(FDCService.baseURL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build();
//
//    IFDCService fdcService = retrofit.create(IFDCService.class);
//
//    Call<SearchResultPOJO> results = fdcService.searchFoods(BuildConfig.FDA_FDC_KEY, "Dorito");
//
//    results.enqueue(new Callback<SearchResultPOJO>() {
//      @Override
//      public void onResponse(Call<SearchResultPOJO> call, Response<SearchResultPOJO> response) {
//        Log.d("FDCService", "SUCCESS");
//        List<SearchResultDTO> resultDTOList = response.body().getFoods().stream().map(SearchResultDTO::parsePOJO).collect(
//            Collectors.toList());
//        resultDTOList.forEach(v -> Log.d("FDCService", String.format(
//            ".\nID: %d\nBRAND NAME: %s\nNAME: %s\nKCAL/100g: %.2f\n",
//            v.id,
//            v.brandName,
//            v.name,
//            v.kcal
//        )));
//      }
//
//      @Override
//      public void onFailure(Call<SearchResultPOJO> call, Throwable t) {
//        Log.d("FDCService", t.getMessage());
//        Log.d("FDCService", call.request().toString());
//      }
//    });
  }

}