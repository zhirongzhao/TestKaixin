package com.as.testkaixin.presenter.bs;

import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.as.testkaixin.R;
import com.as.testkaixin.model.bs.IUserModel;
import com.as.testkaixin.model.bs.UserModelWithRetrofit;
import com.as.testkaixin.view.bs.GuidActivity;
import com.as.testkaixin.view.bs.LoginActivity;
import com.as.testkaixin.vo.bs.LoginVO;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by samsung on 2015/12/8.
 */
public class UserPresenter {
    private LoginActivity view;
    private IUserModel model;
    public  UserPresenter(LoginActivity view) {
        this.view = view;
        this.model = new UserModelWithRetrofit();
    }

    public void login(){

        Map<String,String> param = new HashMap<String,String>();
        TelephonyManager telephonyManager=view.getTelephonyManager();

        param.put("getsimi","1");
        param.put("oauth_signature",	"amKXSOzlFp98jVzCEj34C2brZF4=");
        param.put("device_name",	"unknown$!AndroidSDKbuiltforx86");
        param.put("x_auth_username",	"zhirong.zhao@samsung.com");
        param.put("x_auth_mode",	"client_auth");
        param.put("oauth_version",	"1.0");
        param.put("oauth_nonce",	"d6b9990d99b3777aaea541ae36380ad1");
        param.put("oauth_signature_method",	"HMAC-SHA1");
        param.put("oauth_consumer_key",	"87247717949570179fa41c43e20ed289");
        param.put("ctype",	"15803AndroidClient");
        param.put("x_auth_password",	"qwer1324!");
        param.put("oauth_timestamp", "1450139034");

        model.login(param,
                loginVo -> {
                    view.setProgressBar(false);
                    view.setLoginInfo(R.string.loginActivity_successMsg);
                    if((loginVo!=null)&& (loginVo.getCaptcha_url()!=null)&&!"".equals(loginVo.getCaptcha_url())) {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.LOGIN_CHECK");
                        intent.putExtra("url", loginVo.getCaptcha_url());
                        view.startActivity(intent);
                        view.finish();
                    }else{
                        view.setLoginInfo(R.string.loginActivity_errorMsg);
                        Intent intent = new Intent(view, GuidActivity.class);
                        view.startActivity(intent);
                        view.finish();
                    }
                }
                , throwable -> {
                    view.setProgressBar(false);
                    Log.d("Error message", throwable.getLocalizedMessage());
                    view.setLoginInfo(R.string.loginActivity_errorMsg);
                    Intent intent = new Intent(view, GuidActivity.class);
                    view.startActivity(intent);
                    view.finish();
                }
        );

    }

    public interface OnLoginSuccessListener {
        void onSuccess(LoginVO v);
    }
    public interface OnLoginErrorListener {
        void onError(Throwable v);
    }


}
