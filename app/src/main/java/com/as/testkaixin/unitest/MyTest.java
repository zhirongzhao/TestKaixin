package com.as.testkaixin.unitest;

import android.test.InstrumentationTestCase;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by samsung on 2015/12/28.
 */
public class MyTest extends InstrumentationTestCase{
        public void test() throws Exception{
            Observable myob = Observable.create(new Observable.OnSubscribe<String>(
            ) {
                @Override
                public void call(Subscriber<? super String> subscriber) {
                    System.out.println("Hello World");
                }
            });

            Subscriber<String> mySub = new Subscriber<String>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(String s) {
                    System.out.println(s);
                }
            };

            myob.subscribe(mySub);
        }
}
