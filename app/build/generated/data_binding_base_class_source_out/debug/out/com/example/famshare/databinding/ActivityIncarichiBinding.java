// Generated by view binder compiler. Do not edit!
package com.example.famshare.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.famshare.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityIncarichiBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView recyclerviewi;

  @NonNull
  public final TextView textInc;

  private ActivityIncarichiBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView recyclerviewi, @NonNull TextView textInc) {
    this.rootView = rootView;
    this.recyclerviewi = recyclerviewi;
    this.textInc = textInc;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityIncarichiBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityIncarichiBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_incarichi, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityIncarichiBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.recyclerviewi;
      RecyclerView recyclerviewi = ViewBindings.findChildViewById(rootView, id);
      if (recyclerviewi == null) {
        break missingId;
      }

      id = R.id.textInc;
      TextView textInc = ViewBindings.findChildViewById(rootView, id);
      if (textInc == null) {
        break missingId;
      }

      return new ActivityIncarichiBinding((ConstraintLayout) rootView, recyclerviewi, textInc);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
