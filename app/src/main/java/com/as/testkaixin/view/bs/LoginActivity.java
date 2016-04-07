package com.as.testkaixin.view.bs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.as.testkaixin.R;
import com.as.testkaixin.presenter.bs.UserPresenter;
import com.as.testkaixin.util.KXConstant;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends Activity {
    @Bind(R.id.loginNM)
    EditText loginNM;
    @Bind(R.id.loginPass)
    EditText loginPass;
    @Bind(R.id.loginForgetPass)
    TextView loginForgetPass;
    @Bind(R.id.loginBtn)
    Button loginBtn;
    @Bind(R.id.button)
    Button weboLogin;
    @Bind(R.id.button2)
    Button weChartLogin;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        userPresenter = new UserPresenter(this);
        registerListner();




    }

    private void registerListner(){
        loginBtn.setOnClickListener(v -> {
            setProgressBar(true);
            userPresenter.login();
        });
        weboLogin.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.LOGIN_CHECK");
            startActivity(intent);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.zhirong.zhaozhi
        getMenuInflater().inflate(R.menu.menu_login, menu);
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


    public String getUserName() {
        String loginNm = this.loginNM.getText().toString();

        if(loginNm==null||"".equals(loginNm)){

            Toast.makeText(this, R.string.loginActivity_LoginNmNull,Toast.LENGTH_SHORT).show();
        }
        return loginNm;
    }


    public String getPassWd() {
        String passWord = this.loginPass.getText().toString();

        if(passWord==null||"".equals(passWord)){
            Toast.makeText(this, R.string.loginActivity_passWordNull,Toast.LENGTH_SHORT).show();
        }
        return passWord;
    }



    public void setLoginInfo(int loginInfo) {
        Toast.makeText(this, loginInfo,Toast.LENGTH_SHORT).show();
    }


    public TelephonyManager getTelephonyManager() {
        return (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
    }


    public void setProgressBar(boolean visible) {
        if(visible){
            progressBar.setVisibility(View.VISIBLE);
        }else{
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onBackPressed() {
        exit();
    }

    long mExitTime = 0;
    private void exit() {
        if (System.currentTimeMillis() - mExitTime > KXConstant.INTERVAL) {
            Toast.makeText(this, R.string.global_exit, Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
           finish();
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
            return;
        }
    }
}
