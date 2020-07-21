package com.paydunya.paydunyapsrlibrary.Common;

import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    public BaseFragment() {
    }


    public BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }


    public void hideProgressDialog() {
        getBaseActivity().hideProgressDialog();
    }


    public void showAlertDialog(String message, String positiveButton, boolean withNegativButton, String negativeButton, String image, BaseActivity.AlertDialogListener alertDialogListener) {
        getBaseActivity().showAlertDialog(message, positiveButton, withNegativButton, negativeButton, image, alertDialogListener);
    }


    public void showCustomProgressAlertDialog(String message) {
        getBaseActivity().showCustomProgressAlertDialog(message);
    }

    public void hideCustomProgressAlertDialog() {
        getBaseActivity().hideCustomProgressAlertDialog();
    }

    public void setTitle(String title) {
        getBaseActivity().setTitle(title);
    }


}
