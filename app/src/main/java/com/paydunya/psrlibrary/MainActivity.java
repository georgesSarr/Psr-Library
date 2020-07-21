package com.paydunya.psrlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.paydunya.paydunyapsrlibrary.Constants.IntentConstants;
import com.paydunya.paydunyapsrlibrary.Managers.PaymentManager;
import com.paydunya.paydunyapsrlibrary.PayInActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, PayInActivity.class);
        PaymentManager paymentManager = PaymentManager.getInstance();
        paymentManager.setPaydunyaPrivateKey("live_private_oDevjdjRJdpYhnaRTXzXaWrAO7M");
        paymentManager.setPaydunyaMasterKey("UBAVWOg1-ZFlS-M6KT-bPGD-DUaywar5npJ4");
        paymentManager.setPaydunyaToken("oEo3cBebzBeVpH2nQhcP");
        paymentManager.setAmount(200);
        paymentManager.initPayment(this);
    }
}
