package cmpsc475.emc37.cico.services;

import cmpsc475.emc37.cico.BuildConfig;
import cmpsc475.emc37.cico.models.SearchResultPOJO;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class FDCService {
  public static final String baseURL = "https://api.nal.usda.gov/fdc/";
  private static final String KEY = BuildConfig.FDA_FDC_KEY;

  private static volatile IFDCService INSTANCE;

  private static IFDCService getFDCService() {
    if (INSTANCE == null) {
      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl(baseURL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();

      synchronized (FDCService.class) {
        if (INSTANCE == null) {
          INSTANCE = retrofit.create(IFDCService.class);
        }
      }
    }
    return INSTANCE;
  }

  public static Call<SearchResultPOJO> searchFood(String foodName) {
    return getFDCService().searchFood(KEY, foodName);
  }
}
