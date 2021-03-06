// Generated by view binder compiler. Do not edit!
package com.example.famshare.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.famshare.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ReqentryBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final Button button3;

  @NonNull
  public final TextView textdate2;

  @NonNull
  public final TextView texttitle2;

  private ReqentryBinding(@NonNull CardView rootView, @NonNull Button button3,
      @NonNull TextView textdate2, @NonNull TextView texttitle2) {
    this.rootView = rootView;
    this.button3 = button3;
    this.textdate2 = textdate2;
    this.texttitle2 = texttitle2;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ReqentryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ReqentryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.reqentry, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ReqentryBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button3;
      Button button3 = ViewBindings.findChildViewById(rootView, id);
      if (button3 == null) {
        break missingId;
      }

      id = R.id.textdate2;
      TextView textdate2 = ViewBindings.findChildViewById(rootView, id);
      if (textdate2 == null) {
        break missingId;
      }

      id = R.id.texttitle2;
      TextView texttitle2 = ViewBindings.findChildViewById(rootView, id);
      if (texttitle2 == null) {
        break missingId;
      }

      return new ReqentryBinding((CardView) rootView, button3, textdate2, texttitle2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
