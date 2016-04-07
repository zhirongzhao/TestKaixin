package com.as.testkaixin.view.bs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.as.testkaixin.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CheckNumberActivity extends Activity {

    @Bind(R.id.imgCheck)
    ImageView imgCheck;
    @Bind(R.id.progressBar2)
    ProgressBar progressBar2;
    @Bind(R.id.editText)
    EditText editText;
    @Bind(R.id.button3)
    Button button3;

    Picasso picasso ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_number);
        ButterKnife.bind(this);
        Intent it = getIntent();
        String url= it.getStringExtra("url");
        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
        picasso =Picasso.with(this);
        loadImage(url);

        progressBar2.setOnClickListener(v -> {
            progressBar2.setVisibility(View.VISIBLE);
            loadImage(url);
        });

        button3.setOnClickListener(v -> {
            progressBar2.setVisibility(View.VISIBLE);
            Toast.makeText(this,"x999x",Toast.LENGTH_SHORT).show();
        });

        progressBar2.getHeight();



    }

    public int Dp2Px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }


    public void loadImage(String url){
        Display mDisplay = getWindowManager().getDefaultDisplay();
        Point outSize=new Point();
        mDisplay.getSize(outSize);
        Log.d("xxxxxxxxxxxx", progressBar2.getHeight() + "");
        Log.d("xxxxxxxxxxxx", this.Dp2Px(this,48)+"");
        picasso.setIndicatorsEnabled(true);
        picasso.invalidate(url);
        picasso.load(url).resize(((outSize.x)/2-32), this.Dp2Px(this,48)).into(imgCheck);
        progressBar2.setIndeterminate(false);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_check_number, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
