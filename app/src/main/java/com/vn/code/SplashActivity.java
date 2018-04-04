package com.vn.code;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cross.CrossFullscreenAd;
import facebook.FacebookInterstitial;
import inter.OnErrorLoadAd;
import richadx.RichInterstialAd;

/**
 * Created by d on 1/24/2018.
 */

public class SplashActivity extends AppCompatActivity {
    FacebookInterstitial facebookInterstitial;
    RichInterstialAd mRichInterstialAd;


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        mRichInterstialAd = new RichInterstialAd(this, "/112517806/319401519264355");
        facebookInterstitial = new FacebookInterstitial(this, "");
        try {
            mRichInterstialAd.setOnErrorLoadAd(new OnErrorLoadAd() {
                @Override
                public void onMyError() {
                    CrossFullscreenAd.show(SplashActivity.this);
                }
            });
            mRichInterstialAd.show();
        } catch (Exception e) {
            finish();
        }
    }

}
