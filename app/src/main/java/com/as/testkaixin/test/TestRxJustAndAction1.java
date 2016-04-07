package com.as.testkaixin.test;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by samsung on 2015/12/14.
 */
public class TestRxJustAndAction1 {
    public static void main(String ... args){
        Observable<String> myOb = Observable.just("hello Word TestRxJustAndAction1");
        Action1<String> myAction = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);;
            }
        };
        myOb.subscribe(myAction);

    }
}
