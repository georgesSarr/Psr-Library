package com.paydunya.payinlayout.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.paydunya.payinlayout.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OmFragment extends Fragment {

    public OmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_om, container, false);
    }
}
