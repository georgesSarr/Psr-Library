package com.paydunya.paydunyapsrlibrary.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paydunya.paydunyapsrlibrary.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PayDunyaFragment extends Fragment {

    public PayDunyaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pay_dunya, container, false);
    }
}
