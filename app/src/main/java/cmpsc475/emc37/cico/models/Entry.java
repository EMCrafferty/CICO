package cmpsc475.emc37.cico.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Entity(tableName = "entries")
public class Entry {
  private static class Food {
    private String name;
    private int kcal;

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

    public Food(String name, int kcal) {
      setName(name);
      setKcal(kcal);
    }
  }

  @PrimaryKey(autoGenerate = true)
  private Integer id;

  private int kcal;
  @NonNull
  private List<Food> foods;
  @NonNull
  private LocalDateTime timestamp;

  public Entry(int kcal, @NotNull List<Food> foods, @NotNull LocalDateTime timestamp) {
    this.kcal = kcal;
    this.foods = foods;
    this.timestamp = timestamp;
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
  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(@NotNull LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }
}
