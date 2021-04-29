package cmpsc475.emc37.cico.models;

public class SearchResultDTO {
  public final int id;
  public final String brandName;
  public final String name;
  public final double kcal;


  public SearchResultDTO(int id, String brandName, String name, double kcal) {
    this.id = id;
    this.brandName = brandName;
    this.name = name;
    this.kcal = kcal;
  }

  public static SearchResultDTO parsePOJO(SearchResultPOJO.FDCFood food) {
    return new SearchResultDTO(
        food.getFdcId(),
        food.getBrandOwner(),
        food.getDescription(),
        food.getFoodNutrients()
            .stream()
            .filter(v -> v.getNutrientId() == SearchResultPOJO.NUTRIENTS.KCAL.code)
            .findFirst()
            .get()
            .getValue()
    );
  }
}
