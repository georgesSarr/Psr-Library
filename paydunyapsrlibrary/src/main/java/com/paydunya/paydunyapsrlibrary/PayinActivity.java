package com.paydunya.paydunyapsrlibrary;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.paydunya.paydunyapsrlibrary.Fragments.OmFragment;
import com.paydunya.paydunyapsrlibrary.Fragments.PayDunyaFragment;
import com.paydunya.paydunyapsrlibrary.Fragments.VisaFragment;
import com.paydunya.paydunyapsrlibrary.Fragments.WariProximoFragment;

public class PayinActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payin);

        findViewById(R.id.iv_orange_money).setOnClickListener(this);
        findViewById(R.id.iv_visa).setOnClickListener(this);
        findViewById(R.id.iv_paydunya).setOnClickListener(this);
        findViewById(R.id.iv_wari).setOnClickListener(this);
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }
            // Create a new Fragment to be placed in the activity layout
            PayDunyaFragment firstFragment = new PayDunyaFragment();
            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());
            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
            setSelectedColor(R.id.iv_paydunya);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.iv_paydunya) {
            PayDunyaFragment payDunyaFragment = new PayDunyaFragment();
            payDunyaFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, payDunyaFragment).commit();
            setSelectedColor(R.id.iv_paydunya);
        } else if (id == R.id.iv_orange_money) {
            OmFragment omFragment = new OmFragment();
            omFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, omFragment).commit();
            setSelectedColor(R.id.iv_orange_money);
        } else if (id == R.id.iv_visa) {
            VisaFragment visaFragment = new VisaFragment();
            visaFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, visaFragment).commit();
            setSelectedColor(R.id.iv_visa);
        } else if (id == R.id.iv_wari) {
            WariProximoFragment wariProximoFragment = new WariProximoFragment();
            wariProximoFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, wariProximoFragment).commit();
            setSelectedColor(R.id.iv_wari);
        }
    }

    private void setSelectedColor(int selectedId) {

        findViewById(R.id.iv_paydunya).setBackground(getResources().getDrawable(R.drawable.rounded_payment_background));
        findViewById(R.id.iv_wari).setBackground(getResources().getDrawable(R.drawable.rounded_payment_background));
        findViewById(R.id.iv_visa).setBackground(getResources().getDrawable(R.drawable.rounded_payment_background));
        findViewById(R.id.iv_orange_money).setBackground(getResources().getDrawable(R.drawable.rounded_payment_background));
        findViewById(selectedId).setBackground(getResources().getDrawable(R.drawable.rounded_payment_selected_background));
    }
}
