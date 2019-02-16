package com.example.first;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this,
                getString(R.string.admob_app_id));
// Find Banner ad
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        // Display Banner ad
        mAdView.loadAd(adRequest);

    }

    public void onButtonTap(View v){
        Toast myToast = Toast.makeText(
                getApplicationContext(),
                "Don't touch me!!!",
                Toast.LENGTH_LONG
        );
        myToast.show();
    }

    public void aws(View v){
        Log.i("AWS","CLICKED");
        Intent intent = new Intent(this,AWSActivity.class);
        startActivity(intent);
        finish();
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
}
