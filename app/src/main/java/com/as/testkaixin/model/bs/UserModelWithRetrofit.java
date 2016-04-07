package com.as.testkaixin.model.bs;

import com.as.testkaixin.presenter.bs.UserPresenter;
import com.as.testkaixin.util.HttpClientHelper;
import com.as.testkaixin.vo.bs.LoginVO;

import java.util.Map;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by samsung on 2015/12/8.
 */
public class UserModelWithRetrofit implements IUserModel {
    public static final String API_URL = "http://api.kaixin001.com";

    @Override
    public void login(Map<String, String> param, UserPresenter.OnLoginSuccessListener onLoginSuccessLister, UserPresenter.OnLoginErrorListener onLoginErrorListener) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HttpClientHelper service = retrofit.create(HttpClientHelper.class);

        Observable<LoginVO> observable = service.login(param) ;

        observable.subscribeOn(Schedulers.io()).
        observeOn(AndroidSchedulers.mainThread()).
        subscribe( loginVO-> onLoginSuccessLister.onSuccess(loginVO)
                , throwable -> {onLoginErrorListener.onError(throwable);
                }
        );
    }


}
