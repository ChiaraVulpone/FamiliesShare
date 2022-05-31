// Generated by view binder compiler. Do not edit!
package com.example.famshare.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.famshare.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAddPaBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button conAddBtt;

  @NonNull
  public final EditText editTextTextMultiLine;

  @NonNull
  public final EditText editTextYear;

  @NonNull
  public final EditText edittextnomcogPa;

  @NonNull
  public final TextView textView9;

  private ActivityAddPaBinding(@NonNull ConstraintLayout rootView, @NonNull Button conAddBtt,
      @NonNull EditText editTextTextMultiLine, @NonNull EditText editTextYear,
      @NonNull EditText edittextnomcogPa, @NonNull TextView textView9) {
    this.rootView = rootView;
    this.conAddBtt = conAddBtt;
    this.editTextTextMultiLine = editTextTextMultiLine;
    this.editTextYear = editTextYear;
    this.edittextnomcogPa = edittextnomcogPa;
    this.textView9 = textView9;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAddPaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAddPaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_add_pa, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAddPaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.con_add_btt;
      Button conAddBtt = ViewBindings.findChildViewById(rootView, id);
      if (conAddBtt == null) {
        break missingId;
      }

      id = R.id.editTextTextMultiLine;
      EditText editTextTextMultiLine = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextMultiLine == null) {
        break missingId;
      }

      id = R.id.editTextYear;
      EditText editTextYear = ViewBindings.findChildViewById(rootView, id);
      if (editTextYear == null) {
        break missingId;
      }

      id = R.id.edittextnomcogPa;
      EditText edittextnomcogPa = ViewBindings.findChildViewById(rootView, id);
      if (edittextnomcogPa == null) {
        break missingId;
      }

      id = R.id.textView9;
      TextView textView9 = ViewBindings.findChildViewById(rootView, id);
      if (textView9 == null) {
        break missingId;
      }

      return new ActivityAddPaBinding((ConstraintLayout) rootView, conAddBtt, editTextTextMultiLine,
          editTextYear, edittextnomcogPa, textView9);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
