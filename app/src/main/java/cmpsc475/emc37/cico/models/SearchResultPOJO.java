package cmpsc475.emc37.cico.models;

import java.util.List;

public class SearchResultPOJO {
  public static class FDCFood {
    public static class Nutrients {
      int nutrientId;
      int number;
      String name;
      double value;
      String unitName;
      String derivationCode;
      String derivationDescription;

      public Nutrients(int nutrientId, int number, String name, double value, String unitName, String derivationCode, String derivationDescription) {
        this.nutrientId = nutrientId;
        this.number = number;
        this.name = name;
        this.value = value;
        this.unitName = unitName;
        this.derivationCode = derivationCode;
        this.derivationDescription = derivationDescription;
      }

      public Nutrients() {

      }

      public int getNutrientId() {
        return nutrientId;
      }

      public void setNutrientId(int nutrientId) {
        this.nutrientId = nutrientId;
      }

      public int getNumber() {
        return number;
      }

      public void setNumber(int number) {
        this.number = number;
      }

      public String getName() {
        return name;
      }

      public void setName(String name) {
        this.name = name;
      }

      public double getValue() {
        return value;
      }

      public void setValue(double value) {
        this.value = value;
      }

      public String getUnitName() {
        return unitName;
      }

      public void setUnitName(String unitName) {
        this.unitName = unitName;
      }

      public String getDerivationCode() {
        return derivationCode;
      }

      public void setDerivationCode(String derivationCode) {
        this.derivationCode = derivationCode;
      }

      public String getDerivationDescription() {
        return derivationDescription;
      }

      public void setDerivationDescription(String derivationDescription) {
        this.derivationDescription = derivationDescription;
      }
    }

    int fdcId;
    String dataType;
    String description;
    String foodCode;
    List<Nutrients> foodNutrients;
    String publicationDate;
    String scientificName;
    String brandOwner;
    String gtinUpc;
    String ingredients;
    String ndbNumber;
    String additionalDescriptions;
    String allHighlightFields;
    double score;

    public FDCFood(int fdcId, String dataType, String description, String foodCode, List<Nutrients> foodNutrients, String publicationDate, String scientificName, String brandOwner, String gtinUpc, String ingredients, String ndbNumber, String additionalDescriptions, String allHighlightFields, double score) {
      this.fdcId = fdcId;
      this.dataType = dataType;
      this.description = description;
      this.foodCode = foodCode;
      this.foodNutrients = foodNutrients;
      this.publicationDate = publicationDate;
      this.scientificName = scientificName;
      this.brandOwner = brandOwner;
      this.gtinUpc = gtinUpc;
      this.ingredients = ingredients;
      this.ndbNumber = ndbNumber;
      this.additionalDescriptions = additionalDescriptions;
      this.allHighlightFields = allHighlightFields;
      this.score = score;
    }

    public int getFdcId() {
      return fdcId;
    }

    public void setFdcId(int fdcId) {
      this.fdcId = fdcId;
    }

    public String getDataType() {
      return dataType;
    }

    public void setDataType(String dataType) {
      this.dataType = dataType;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public String getFoodCode() {
      return foodCode;
    }

    public void setFoodCode(String foodCode) {
      this.foodCode = foodCode;
    }

    public List<Nutrients> getFoodNutrients() {
      return foodNutrients;
    }

    public void setFoodNutrients(List<Nutrients> foodNutrients) {
      this.foodNutrients = foodNutrients;
    }

    public String getPublicationDate() {
      return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
      this.publicationDate = publicationDate;
    }

    public String getScientificName() {
      return scientificName;
    }

    public void setScientificName(String scientificName) {
      this.scientificName = scientificName;
    }

    public String getBrandOwner() {
      return brandOwner;
    }

    public void setBrandOwner(String brandOwner) {
      this.brandOwner = brandOwner;
    }

    public String getGtinUpc() {
      return gtinUpc;
    }

    public void setGtinUpc(String gtinUpc) {
      this.gtinUpc = gtinUpc;
    }

    public String getIngredients() {
      return ingredients;
    }

    public void setIngredients(String ingredients) {
      this.ingredients = ingredients;
    }

    public String getNdbNumber() {
      return ndbNumber;
    }

    public void setNdbNumber(String ndbNumber) {
      this.ndbNumber = ndbNumber;
    }

    public String getAdditionalDescriptions() {
      return additionalDescriptions;
    }

    public void setAdditionalDescriptions(String additionalDescriptions) {
      this.additionalDescriptions = additionalDescriptions;
    }

    public String getAllHighlightFields() {
      return allHighlightFields;
    }

    public void setAllHighlightFields(String allHighlightFields) {
      this.allHighlightFields = allHighlightFields;
    }

    public double getScore() {
      return score;
    }

    public void setScore(double score) {
      this.score = score;
    }
  }

  int totalHits;
  int currentPage;
  int totalPages;
  List<FDCFood> foods;
  List<Integer> pageList;

  public SearchResultPOJO(int totalHits, int currentPage, int totalPages, List<FDCFood> foods) {
    this.totalHits = totalHits;
    this.currentPage = currentPage;
    this.totalPages = totalPages;
    this.foods = foods;
  }

  public int getTotalHits() {
    return totalHits;
  }

  public void setTotalHits(int totalHits) {
    this.totalHits = totalHits;
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }

  public List<FDCFood> getFoods() {
    return foods;
  }

  public void setFoods(List<FDCFood> foods) {
    this.foods = foods;
  }

  public enum NUTRIENTS {
    KCAL(1008);

    public final int code;

    NUTRIENTS(int code) { this.code = code; }
  }
}
