package com.as.testkaixin.model.bs;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.as.testkaixin.presenter.bs.UserPresenter;
import com.as.testkaixin.vo.bs.LoginVO;
import com.google.gson.Gson;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;


public class UserModelWithOkHttp implements IUserModel{
    public static final String API_URL = "http://api.kaixin001.com/oauth/access_token";
    @Override
    public void login(Map<String, String> param,
                      UserPresenter.OnLoginSuccessListener onLoginSuccessLister,
                      UserPresenter.OnLoginErrorListener onLoginErrorListener) {
         OkHttpClient client = new OkHttpClient();

         Handler mHandler=new LoginHandler(this,onLoginSuccessLister,onLoginErrorListener);

        new Thread(()->{
            FormEncodingBuilder feb = new FormEncodingBuilder();
            Set<Map.Entry<String,String>> entrySet = param.entrySet();
            for(Map.Entry<String,String> entry : entrySet) {
                feb.add(entry.getKey(), entry.getValue());
            }
            RequestBody requestBody = feb.build();
            Request request = new Request.Builder().url(API_URL).post(requestBody).build();
            try {
                com.squareup.okhttp.Response response = client.newCall(request).execute();
                Message m = mHandler.obtainMessage();


                if(response.isSuccessful()){
                    m.what = 1;
                   // Log.d("xxxxxx",response.body().string());
                    String responseBody = response.body().string();
                    Log.d("xxxxxx",responseBody);
                    m.obj =responseBody;
                    mHandler.sendMessage(m);
                }else{
                    m.what = 2;
                    m.obj="Http Error";
                    mHandler.sendMessage(m);
                }
            } catch (Throwable e) {

                e.printStackTrace();
                Message m = mHandler.obtainMessage();
                m.what = 0;
                m.obj=e;
                mHandler.sendMessage(m);
            }


        }).start();

    }


    private static class LoginHandler extends Handler {

        private final WeakReference<UserModelWithOkHttp> mokHttpClient;
        UserPresenter.OnLoginSuccessListener onLoginSuccessLister;
        UserPresenter.OnLoginErrorListener onLoginErrorListener;
        public LoginHandler(UserModelWithOkHttp okHttpClient,
                            UserPresenter.OnLoginSuccessListener onLoginSuccessLister,
                                    UserPresenter.OnLoginErrorListener onLoginErrorListener
        ){
            mokHttpClient = new WeakReference<UserModelWithOkHttp>(okHttpClient);
            this.onLoginErrorListener = onLoginErrorListener;
            this.onLoginSuccessLister = onLoginSuccessLister;
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(msg.what == 0){
                  onLoginErrorListener.onError((Throwable) msg.obj);
            }else if(msg.what == 2){
                  onLoginErrorListener.onError(new Throwable((String) msg.obj));
            }else{
                Gson gson = new Gson();
                LoginVO loginvo = gson.fromJson((String)msg.obj,LoginVO.class);
                 onLoginSuccessLister.onSuccess(loginvo);
            }

        }
    }


}

