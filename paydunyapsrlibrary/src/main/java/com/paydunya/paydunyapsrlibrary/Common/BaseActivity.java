package com.paydunya.paydunyapsrlibrary.Common;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.orhanobut.dialogplus.DialogPlus;
import com.paydunya.paydunyapsrlibrary.R;

public class BaseActivity extends AppCompatActivity {
    private ProgressDialog mProgressDialog;
    private AlertDialog mAlertDialog;

    public void showAlertDialog(String message, String positiveButton, boolean withNegativeButton, String negativeButton, String image, final AlertDialogListener alertDialogListener) {

        final DialogPlus dialog = DialogPlus.newDialog(this)
                .setContentHolder(new com.orhanobut.dialogplus.ViewHolder(R.layout.custom_alert_dialog))
                .setCancelable(false)
                .setMargin(70, 10, 70, 10)
                .setPadding(10, 5, 10, 0)
                .setContentBackgroundResource(R.drawable.rounded_element)
                .setGravity(Gravity.CENTER)
                .create();

        LottieAnimationView imgDialogWarning = (LottieAnimationView) dialog.findViewById(R.id.lottie_custom_dialog_warning);
        LottieAnimationView imgDialogChecked = (LottieAnimationView) dialog.findViewById(R.id.lottie_custom_dialog_check);
        if (image.equals("success")) {
            imgDialogChecked.setVisibility(View.VISIBLE);
        } else if (image.equals("warning")) {
            imgDialogWarning.setVisibility(View.VISIBLE);
        }

        TextView tvMessage = (TextView) dialog.findViewById(R.id.tv_custom_dialog_message);
        TextView tvPositive = (TextView) dialog.findViewById(R.id.tv_positive_button);
        TextView tvNegative = (TextView) dialog.findViewById(R.id.tv_negative_button);
        tvMessage.setText(message);
        tvPositive.setText(positiveButton);
        if (withNegativeButton) {
            tvNegative.setText(negativeButton);
        }
        tvPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                alertDialogListener.onConfirm();
            }
        });
        tvNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                alertDialogListener.onCancel();
            }
        });

        dialog.show();


    }

    public void showCustomProgressAlertDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View customLayout = getLayoutInflater().inflate(R.layout.custom_loading_dialog, null);
        ((TextView) customLayout.findViewById(R.id.tv_custom_dialog_message)).setText(message);
        builder.setView(customLayout);

        mAlertDialog = builder.create();
        mAlertDialog.setCancelable(false);
        mAlertDialog.show();
    }

    public void hideCustomProgressAlertDialog() {
        if (mAlertDialog != null && mAlertDialog.isShowing()) {
            mAlertDialog.cancel();
        }
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }

    public interface AlertDialogListener {
        void onConfirm();

        void onCancel();
    }


}
