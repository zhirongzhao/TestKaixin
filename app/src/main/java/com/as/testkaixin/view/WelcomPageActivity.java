package com.as.testkaixin.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;

import com.as.testkaixin.R;
import com.as.testkaixin.view.bs.LoginActivity;
import com.squareup.picasso.Picasso;

public class WelcomPageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom_page);
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        Picasso.with(this).setIndicatorsEnabled(true);
        Display mDisplay = getWindowManager().getDefaultDisplay();
        Point outSize=new Point();
        mDisplay.getSize(outSize);
        Log.i("Main", "Width = " + outSize.x);
        Log.i("Main", "Height = " + outSize.y);


        Picasso.with(this).load("http://attachments.gfan.com/forum/201507/22/101051o3d5ffp7i6d3nbi2.jpg").resize(outSize.x, outSize.y).into(iv);
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                Intent intent = new Intent(WelcomPageActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public void onBackPressed() {
        finish();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
        return;
    }

}
