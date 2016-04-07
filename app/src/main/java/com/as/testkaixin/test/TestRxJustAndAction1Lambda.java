package com.as.testkaixin.test;

import rx.Observable;

/**
 * Created by samsung on 2015/12/14.
 */
public class TestRxJustAndAction1Lambda {
    public static void main(String ... args){
//        Observable.just("hello Word TestRxJustAndAction1").subscribe(
//             new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println(s);;
//            }
//        });
        Observable.just("hell lambda").subscribe(s->System.out.println(s));

    }
}
