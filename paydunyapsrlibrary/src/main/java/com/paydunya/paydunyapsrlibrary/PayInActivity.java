package com.paydunya.paydunyapsrlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hbb20.CountryCodePicker;
import com.paydunya.paydunyapsrlibrary.Common.BaseActivity;
import com.paydunya.paydunyapsrlibrary.Constants.IntentConstants;
import com.paydunya.paydunyapsrlibrary.FragmentBenin.MtnBeninFragment;
import com.paydunya.paydunyapsrlibrary.FragmentCI.FragmentOmCI;
import com.paydunya.paydunyapsrlibrary.FragmentCI.MtnCiFragment;
import com.paydunya.paydunyapsrlibrary.Fragments.OmFragment;
import com.paydunya.paydunyapsrlibrary.Fragments.PayDunyaFragment;
import com.paydunya.paydunyapsrlibrary.Fragments.VisaFragment;
import com.paydunya.paydunyapsrlibrary.Fragments.WariProximoFragment;
import com.paydunya.paydunyapsrlibrary.Fragments.WizallFragment;
import com.paydunya.paydunyapsrlibrary.Managers.PaymentManager;

public class PayInActivity extends BaseActivity implements View.OnClickListener {

    //public String invoiceToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payin);

        //Intent intent = getIntent();
        //invoiceToken = intent.getStringExtra(IntentConstants.INVOICE_TOKEN);




        findViewById(R.id.iv_orange_money).setOnClickListener(this);
        findViewById(R.id.iv_visa).setOnClickListener(this);
        findViewById(R.id.iv_paydunya).setOnClickListener(this);
        findViewById(R.id.iv_wari).setOnClickListener(this);
        findViewById(R.id.iv_mtn_benin).setOnClickListener(this);
        findViewById(R.id.iv_om_ci).setOnClickListener(this);
        findViewById(R.id.iv_mtn_ci).setOnClickListener(this);
        findViewById(R.id.iv_wizall).setOnClickListener(this);

        final CountryCodePicker countryCodePicker = findViewById(R.id.ccp);
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
        countryCodePicker.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                setAvailableCountryPaymentMethod(countryCodePicker.getSelectedCountryNameCode());
                }
        });
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
        else if (id == R.id.iv_wizall) {
            WizallFragment wizallFragment = new WizallFragment();
            wizallFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, wizallFragment).commit();
            setSelectedColor(R.id.iv_wizall);
        }
    else if (id == R.id.iv_om_ci) {
            FragmentOmCI fragmentOmCI = new FragmentOmCI();
            fragmentOmCI.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragmentOmCI).commit();
            setSelectedColor(R.id.iv_om_ci);
        }
    else if (id == R.id.iv_mtn_ci) {
            MtnCiFragment mtnCiFragment = new MtnCiFragment();
            mtnCiFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, mtnCiFragment).commit();
            setSelectedColor(R.id.iv_mtn_ci);
        }
    else if (id == R.id.iv_mtn_benin) {
            MtnBeninFragment mtnBeninFragment = new MtnBeninFragment();
            mtnBeninFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, mtnBeninFragment).commit();
            setSelectedColor(R.id.iv_mtn_benin);
        }
    }

    private void setAvailableCountryPaymentMethod(String countryCode){
        VisaFragment visaFragment = new VisaFragment();
        visaFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, visaFragment).commit();
        setSelectedColor(R.id.iv_visa);
        switch (countryCode) {
            case "SN":
                findViewById(R.id.iv_paydunya).setVisibility(View.VISIBLE);
                findViewById(R.id.iv_wari).setVisibility(View.VISIBLE);
                findViewById(R.id.iv_visa).setVisibility(View.VISIBLE);
                findViewById(R.id.iv_orange_money).setVisibility(View.VISIBLE);
                findViewById(R.id.iv_om_ci).setVisibility(View.GONE);
                findViewById(R.id.iv_mtn_ci).setVisibility(View.GONE);
                findViewById(R.id.iv_mtn_benin).setVisibility(View.GONE);
                break;
            case "CI":
                findViewById(R.id.iv_paydunya).setVisibility(View.GONE);
                findViewById(R.id.iv_wari).setVisibility(View.GONE);
                findViewById(R.id.iv_visa).setVisibility(View.VISIBLE);
                findViewById(R.id.iv_orange_money).setVisibility(View.GONE);
                findViewById(R.id.iv_om_ci).setVisibility(View.VISIBLE);
                findViewById(R.id.iv_mtn_ci).setVisibility(View.VISIBLE);
                findViewById(R.id.iv_mtn_benin).setVisibility(View.GONE);
                break;
            case "BJ":
                findViewById(R.id.iv_paydunya).setVisibility(View.GONE);
                findViewById(R.id.iv_wari).setVisibility(View.GONE);
                findViewById(R.id.iv_visa).setVisibility(View.VISIBLE);
                findViewById(R.id.iv_orange_money).setVisibility(View.GONE);
                findViewById(R.id.iv_om_ci).setVisibility(View.GONE);
                findViewById(R.id.iv_mtn_ci).setVisibility(View.GONE);
                findViewById(R.id.iv_mtn_benin).setVisibility(View.VISIBLE);
                break;
        }
    }

    private void setSelectedColor(int selectedId) {
        findViewById(R.id.iv_paydunya).setBackground(getResources().getDrawable(R.drawable.rounded_payment_background));
        findViewById(R.id.iv_wari).setBackground(getResources().getDrawable(R.drawable.rounded_payment_background));
        findViewById(R.id.iv_visa).setBackground(getResources().getDrawable(R.drawable.rounded_payment_background));
        findViewById(R.id.iv_orange_money).setBackground(getResources().getDrawable(R.drawable.rounded_payment_background));
        findViewById(R.id.iv_om_ci).setBackground(getResources().getDrawable(R.drawable.rounded_payment_background));
        findViewById(R.id.iv_mtn_ci).setBackground(getResources().getDrawable(R.drawable.rounded_payment_background));
        findViewById(R.id.iv_mtn_benin).setBackground(getResources().getDrawable(R.drawable.rounded_payment_background));
        findViewById(R.id.iv_wizall).setBackground(getResources().getDrawable(R.drawable.rounded_payment_background));
        findViewById(selectedId).setBackground(getResources().getDrawable(R.drawable.rounded_payment_selected_background));
    }


}
