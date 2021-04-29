package cmpsc475.emc37.cico.services;

import java.util.List;

import cmpsc475.emc37.cico.models.SearchResultPOJO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IFDCService {

  @GET("/fdc/v1/foods/search")
  Call<SearchResultPOJO> searchFoods(@Query("api_key") String key, @Query("query") String foodName);

}
