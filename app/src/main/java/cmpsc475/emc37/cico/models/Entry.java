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
    private double servings;

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

    public double getServings() {
      return servings;
    }

    public void setServings(double servings) {
      this.servings = servings;
    }

    public Food(String name, int kcal, double servings) {
      setName(name);
      setKcal(kcal);
      setServings(servings);
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
}
