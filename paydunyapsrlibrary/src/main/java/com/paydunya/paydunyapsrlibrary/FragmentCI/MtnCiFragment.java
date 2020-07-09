package com.paydunya.paydunyapsrlibrary.FragmentCI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paydunya.paydunyapsrlibrary.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MtnCiFragment extends Fragment {

    public MtnCiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mtn_ci, container, false);
    }
}
