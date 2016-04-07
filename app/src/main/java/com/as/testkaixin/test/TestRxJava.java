package com.as.testkaixin.test;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by samsung on 2015/12/14.
 */
public class TestRxJava {
    public static void main(String ... args){
        Observable myob = Observable.create(new Observable.OnSubscribe<String>(
        ) {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello World!!! OnNext");
                subscriber.onCompleted();

            }
        });

        Subscriber<String> mySub = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };

        myob.subscribe(mySub);

    }
}
