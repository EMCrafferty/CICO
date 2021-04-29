package cmpsc475.emc37.cico;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

import cmpsc475.emc37.cico.models.SearchResultPOJO;
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
    SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
    ViewPager viewPager = findViewById(R.id.view_pager);
    viewPager.setAdapter(sectionsPagerAdapter);
    TabLayout tabs = findViewById(R.id.tabs);
    tabs.setupWithViewPager(viewPager);
    //


    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(FDCService.baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    IFDCService fdcService = retrofit.create(IFDCService.class);

    Call<SearchResultPOJO> results = fdcService.searchFoods(BuildConfig.FDA_FDC_KEY, "Dorito");

    results.enqueue(new Callback<SearchResultPOJO>() {
      @Override
      public void onResponse(Call<SearchResultPOJO> call, Response<SearchResultPOJO> response) {
        Log.d("FDCService", "SUCCESS");
        Log.d("FDCService", String.valueOf(response.body().getFoods().get(0).getFoodNutrients().get(0).getNutrientId()));
      }

      @Override
      public void onFailure(Call<SearchResultPOJO> call, Throwable t) {
        Log.d("FDCService", t.getMessage());
        Log.d("FDCService", call.request().toString());
      }
    });
  }

}