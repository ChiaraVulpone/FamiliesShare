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

public final class ActivityAddReqBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button addreqButton1;

  @NonNull
  public final TextView addreqText;

  @NonNull
  public final EditText editTextTextDesc1;

  @NonNull
  public final EditText editTextTitle1;

  @NonNull
  public final EditText editdate1;

  private ActivityAddReqBinding(@NonNull ConstraintLayout rootView, @NonNull Button addreqButton1,
      @NonNull TextView addreqText, @NonNull EditText editTextTextDesc1,
      @NonNull EditText editTextTitle1, @NonNull EditText editdate1) {
    this.rootView = rootView;
    this.addreqButton1 = addreqButton1;
    this.addreqText = addreqText;
    this.editTextTextDesc1 = editTextTextDesc1;
    this.editTextTitle1 = editTextTitle1;
    this.editdate1 = editdate1;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAddReqBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAddReqBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_add_req, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAddReqBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addreqButton1;
      Button addreqButton1 = ViewBindings.findChildViewById(rootView, id);
      if (addreqButton1 == null) {
        break missingId;
      }

      id = R.id.addreqText;
      TextView addreqText = ViewBindings.findChildViewById(rootView, id);
      if (addreqText == null) {
        break missingId;
      }

      id = R.id.editTextTextDesc1;
      EditText editTextTextDesc1 = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextDesc1 == null) {
        break missingId;
      }

      id = R.id.editTextTitle1;
      EditText editTextTitle1 = ViewBindings.findChildViewById(rootView, id);
      if (editTextTitle1 == null) {
        break missingId;
      }

      id = R.id.editdate1;
      EditText editdate1 = ViewBindings.findChildViewById(rootView, id);
      if (editdate1 == null) {
        break missingId;
      }

      return new ActivityAddReqBinding((ConstraintLayout) rootView, addreqButton1, addreqText,
          editTextTextDesc1, editTextTitle1, editdate1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
