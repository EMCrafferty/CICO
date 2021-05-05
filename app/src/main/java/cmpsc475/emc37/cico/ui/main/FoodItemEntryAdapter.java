package cmpsc475.emc37.cico.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import cmpsc475.emc37.cico.R;
import cmpsc475.emc37.cico.models.Entry;


public class FoodItemEntryAdapter
    extends RecyclerView.Adapter<FoodItemEntryAdapter.FoodItemEntryHolder> {
  class FoodItemEntryHolder extends RecyclerView.ViewHolder {
    private TextView foodName;
    private TextView brandName;
    private TextView kcal;
    private TextView serving;


    public FoodItemEntryHolder(@NonNull View itemView) {
      super(itemView);
      foodName = itemView.findViewById(R.id.textViewFoodName);
      brandName = itemView.findViewById(R.id.textViewBrandName);
      kcal = itemView.findViewById(R.id.textViewKcal);
      serving = itemView.findViewById(R.id.textViewUnits);
    }
  }

  public interface ItemClickListener {
    void onItemClick(View view);
  }

  private List<Entry> items = new ArrayList<>();
  private FoodItemEntryAdapter.ItemClickListener itemClickListener;

  public FoodItemEntryAdapter(FoodItemEntryAdapter.ItemClickListener itemClickListener) {
    this.itemClickListener = itemClickListener;
  }

  @NonNull
  @Override
  public FoodItemEntryAdapter.FoodItemEntryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.food_item, parent, false);
    return new FoodItemEntryAdapter.FoodItemEntryHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull FoodItemEntryAdapter.FoodItemEntryHolder holder, int position) {
    Entry currentItem = items.get(position);
    holder.foodName.setText(currentItem.getFoods()
                                       .get(0)
                                       .getName());
    OffsetDateTime timestamp = currentItem.getTimestamp();
    holder.brandName.setText(String.format("%s-%s-%s",
                                           timestamp.getYear(),
                                           timestamp.getMonth(),
                                           timestamp.getDayOfMonth()));

    holder.kcal.setText(String.valueOf(currentItem.getKcal()));
    holder.serving.setText(String.format(Locale.getDefault(), "%.0fg", currentItem.getFoods()
                                                                                  .get(0)
                                                                                  .getGrams()));
    holder.itemView.setOnClickListener(itemClickListener::onItemClick);
  }

  @Override
  public int getItemCount() {
    return items.size();
  }

  public void setItems(List<Entry> items) {
    this.items = items;
    notifyDataSetChanged();
  }
}