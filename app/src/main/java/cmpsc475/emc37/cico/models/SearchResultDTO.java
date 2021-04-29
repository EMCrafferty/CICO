package cmpsc475.emc37.cico.models;

public class SearchResultDTO {
  final int id;
  final String brandName;
  final String name;
  final int kcal;

  public SearchResultDTO(int id, String brandName, String name, int kcal) {
    this.id = id;
    this.brandName = brandName;
    this.name = name;
    this.kcal = kcal;
  }
}
