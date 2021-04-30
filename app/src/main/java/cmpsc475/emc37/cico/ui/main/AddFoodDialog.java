package cmpsc475.emc37.cico.ui.main;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import cmpsc475.emc37.cico.R;

public class AddFoodDialog extends DialogFragment {
  private String title;

  public AddFoodDialog() { }

  public interface AddFoodClickListener {
    void onAddFoodClick(Object _dialog, Object _id);
  }

  private AddFoodClickListener addFoodClickListener;

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    LayoutInflater inflater = requireActivity().getLayoutInflater();

    builder.setView(inflater.inflate(R.layout.add_food_dialog_fragment, null))
           .setPositiveButton("ADD", addFoodClickListener::onAddFoodClick)
           .setNegativeButton("CANCEL", null);

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
}
