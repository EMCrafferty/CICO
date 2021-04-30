package cmpsc475.emc37.cico.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import cmpsc475.emc37.cico.R;
import cmpsc475.emc37.cico.models.SearchResultDTO;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.FoodItemHolder> {
  class FoodItemHolder extends RecyclerView.ViewHolder {
    private TextView foodName;
    private TextView brandName;
    private TextView kcal;

    public FoodItemHolder(@NonNull View itemView) {
      super(itemView);
      foodName = itemView.findViewById(R.id.textViewFoodName);
      brandName = itemView.findViewById(R.id.textViewBrandName);
      kcal = itemView.findViewById(R.id.textViewKcal);
    }
  }

  private List<SearchResultDTO> items = new ArrayList<>();

  @NonNull
  @Override
  public FoodItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.food_item, parent, false);
    return new FoodItemHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull FoodItemHolder holder, int position) {
    SearchResultDTO currentItem = items.get(position);
    holder.foodName.setText(currentItem.name);
    holder.brandName.setText(currentItem.brandName);
    holder.kcal.setText(String.valueOf((int) currentItem.kcal));

    holder.itemView.setOnClickListener(v -> {
      Snackbar.make(v, holder.foodName.getText(), Snackbar.LENGTH_LONG).show();
    });
  }

  @Override
  public int getItemCount() {
    return items.size();
  }

  public void setItems(List<SearchResultDTO> items) {
    this.items = items;
    notifyDataSetChanged();
  }
}
