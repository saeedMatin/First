/*package com.example.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AWSCalculateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awscalculate);
    }
}
*/
package com.example.first;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class AWSCalculateActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awscalculate);
        MobileAds.initialize(this,
                getString(R.string.admob_app_id));
// Find Banner ad
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        // Display Banner ad
        mAdView.loadAd(adRequest);

        //disable screen capture
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
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

    public void back(View v){
        Log.i("back","CLICKED");
        Intent intent = new Intent(this,AWSActivity.class);
        startActivity(intent);
        finish();
    }
    public void first_page(View v){
        Log.i("back","CLICKED");
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void onButtonTap(View v){
        //final EditText et = (EditText) findViewById(R.id.testtext);
        Toast myToast = Toast.makeText(
                getApplicationContext(),
                "Don't touch me!!!",
                //et.getText().toString(),
                Toast.LENGTH_LONG
        );
        myToast.show();
    }


}
