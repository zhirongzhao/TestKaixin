package com.as.testkaixin.test;


import org.apache.commons.codec.binary.*;


/**
 * Created by samsung on 2015/12/17.
 */
public class TestBase64 {

    public static  void main(String ... args){
//        String str = "Hello!";
//        String strBase64 = new String(Base64.encode(str.getBytes(), Base64.DEFAULT));
//        System.out.println(strBase64);
//        String enToStr = Base64.encodeToString(str.getBytes(), Base64.DEFAULT);
//        System.out.println(enToStr);
        String base64String = "whuang123";
        byte[] result = Base64.encodeBase64(base64String.getBytes());
        System.out.println(new String(result));

        String param = "amKXSOzlFp98jVzCEj34C2brZF4=" ;
        byte[] byParam = param.getBytes();
        result =Base64.decodeBase64(byParam);
        System.out.println(new String(result));
    }
}
