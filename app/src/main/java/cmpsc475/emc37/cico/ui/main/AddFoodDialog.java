package cmpsc475.emc37.cico.ui.main;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Locale;

import cmpsc475.emc37.cico.R;
import cmpsc475.emc37.cico.models.Entry;

public class AddFoodDialog extends DialogFragment {
  EditText portion;
  TextView textViewKcals;
  View foodItem;
  int kcals;

  public AddFoodDialog() { }

  public AddFoodDialog(View foodItem) {
    TextView kcalView = foodItem.findViewById(R.id.textViewKcal);
    this.kcals = Integer.parseInt(kcalView.getText().toString());
    this.foodItem = foodItem;
  }

  public interface AddFoodClickListener {
    void onAddFoodClick(int portionKcal, Entry.Food food);
  }

  private AddFoodClickListener addFoodClickListener;

  public View getFoodItem() {
    return foodItem;
  }

  public EditText getPortion() {
    return portion;
  }

  public void setPortion(EditText portion) {
    this.portion = portion;
  }

  public TextView getTextViewKcals() {
    return textViewKcals;
  }

  public void setTextViewKcals(TextView textViewKcals) {
    this.textViewKcals = textViewKcals;
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    LayoutInflater inflater = requireActivity().getLayoutInflater();

    View view = inflater.inflate(R.layout.add_food_dialog_fragment, null);

    builder.setView(view)
           .setTitle("Add Food")
           .setNegativeButton("CANCEL", null)
           .setPositiveButton("ADD", (d, w) ->
             addFoodClickListener.onAddFoodClick(Integer.parseInt(textViewKcals.getText().toString()), packageFood())
           );

    TextView foodName = view.findViewById(R.id.textViewAddFoodTitle);
    portion = view.findViewById(R.id.editTextPortion);
    textViewKcals = view.findViewById(R.id.textViewKcalPortion);
    textViewKcals.setText("0");

    foodName.setText(((TextView) foodItem.findViewById(R.id.textViewFoodName)).getText());

    portion.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {

      }

      @Override
      public void afterTextChanged(Editable s) {
        String portionValue = portion.getText().toString();

        if (!portionValue.isEmpty()) {
          int grams = Integer.parseInt(portion.getText().toString());
          double perGram = kcals / 100f;
          textViewKcals.setText(String.format(Locale.getDefault(), "%.0f", grams * perGram));
        }
        else
          textViewKcals.setText("0");
      }
    });

    return builder.create();
  }

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    try {
      addFoodClickListener = (AddFoodClickListener) context;
    }
    catch (ClassCastException e) {
      throw new ClassCastException(context.toString() + " must implement AddFoodClickListener");
    }
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);


  }

  private Entry.Food packageFood() {
    TextView foodNameView = foodItem.findViewById(R.id.textViewFoodName);

    Entry.Food food = new Entry.Food(
        foodNameView.getText().toString(),
        kcals,
        Double.parseDouble(portion.getText().toString())
    );

    return food;
  }
}
