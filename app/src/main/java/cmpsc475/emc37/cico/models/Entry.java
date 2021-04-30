package cmpsc475.emc37.cico.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import org.jetbrains.annotations.NotNull;

import java.time.OffsetDateTime;
import java.util.List;

@Entity(tableName = "entries")
public class Entry {
  public static class Food {
    private String name;
    private int kcal;
    private double grams;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getKcal() {
      return kcal;
    }

    public void setKcal(int kcal) {
      this.kcal = kcal;
    }

    public double getGrams() {
      return grams;
    }

    public void setGrams(double grams) {
      this.grams = grams;
    }

    public Food(String name, int kcal, double grams) {
      setName(name);
      setKcal(kcal);
      setGrams(grams);
    }

    @NonNull
    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();

      sb.append("( ")
        .append(getName()).append(' ')
        .append(getKcal()).append(' ')
        .append(getGrams()).append(' ')
        .append(')');

      return sb.toString();
    }
  }

  @PrimaryKey(autoGenerate = true)
  private Integer id;

  private int kcal;
  @NonNull
  @TypeConverters(FoodConverter.class)
  private List<Food> foods;
  @NonNull
  @TypeConverters(TimestampConverter.class)
  private OffsetDateTime timestamp;

  public Entry(int kcal, @NotNull List<Food> foods, @NotNull OffsetDateTime timestamp) {
    this.kcal = kcal;
    this.foods = foods;
    this.timestamp = timestamp;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getKcal() {
    return kcal;
  }

  public void setKcal(int kcal) {
    this.kcal = kcal;
  }

  @NotNull
  public List<Food> getFoods() {
    return foods;
  }

  public void setFoods(@NotNull List<Food> foods) {
    this.foods = foods;
  }

  @NotNull
  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(@NotNull OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  @NonNull
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getId()).append('\n')
      .append(getKcal()).append('\n')
      .append(getTimestamp()).append('\n')
      .append("{ ");
    foods.forEach(v -> sb.append(v).append(" "));
    sb.append("}\n");

    return sb.toString();
  }
}