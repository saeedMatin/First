package com.example.first;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class AWSActivity extends Activity {
    //AWSView awsView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aws);
        MobileAds.initialize(this,
                getString(R.string.admob_app_id));
// Find Banner ad
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        // Display Banner ad
        mAdView.loadAd(adRequest);
    }
    @Override
    public void onBackPressed() {
        backButtonEvent();
        return;
    }

    private void backButtonEvent() {
        AlertDialog.Builder exit=new AlertDialog.Builder(this);
        exit.setTitle("!");
        exit.setMessage("Want to exit?");
        exit.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        exit.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        exit.show();
    }
    public void onButtonTap(View v){
        Toast myToast = Toast.makeText(
                getApplicationContext(),
                "Calculate page!!!",
                Toast.LENGTH_LONG
        );
        myToast.show();
    }

    public void onButtonTap2(View v){
        Toast myToast = Toast.makeText(
                getApplicationContext(),
                "Standard hint page!!!",
                Toast.LENGTH_SHORT
        );
        myToast.show();
    }
    public void back(View v){
        Log.i("back","CLICKED");
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void Calc(View v){
        Log.i("calc","CLICKED");
        Intent intent = new Intent(this,AWSCalculateActivity.class);
        startActivity(intent);
        finish();
    }
}