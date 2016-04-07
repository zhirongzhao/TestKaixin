package com.as.testkaixin.model.bs;

import com.as.testkaixin.presenter.bs.UserPresenter;

import java.util.Map;

/**
 * Created by samsung on 2015/12/8.
 */
public interface IUserModel {
    public void login(Map<String,String> param
            ,UserPresenter.OnLoginSuccessListener onLoginSuccessLister
            ,UserPresenter.OnLoginErrorListener onLoginErrorListener
    );
}
