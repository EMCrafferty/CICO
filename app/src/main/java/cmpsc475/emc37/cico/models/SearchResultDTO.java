package cmpsc475.emc37.cico.models;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SearchResultDTO {
  public final int id;
  public final String brandName;
  public final String name;
  public final Double kcal;


  public SearchResultDTO(int id, String brandName, String name, Double kcal) {
    this.id = id;
    this.brandName = brandName;
    this.name = name;
    this.kcal = kcal;
  }

  public static SearchResultDTO parseFood(SearchResultPOJO.FDCFood food) {
    return new SearchResultDTO(
        food.getFdcId(),
        food.getBrandOwner(),
        food.getDescription(),
        food.getFoodNutrients()
            .stream()
            .filter(v -> v.getNutrientId() == SearchResultPOJO.NUTRIENTS.KCAL.code)
            .map(v -> v.getValue())
            .findFirst()
            .orElse(null)
    );
  }

  public static List<SearchResultDTO> parsePOJO(SearchResultPOJO pojo) {
    return pojo.getFoods()
               .stream()
               .map(SearchResultDTO::parseFood)
               .collect(Collectors.toList());
  }
}
