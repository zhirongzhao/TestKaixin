package com.as.testkaixin.test;

import org.keyczar.Encrypter;

/**
 * Created by samsung on 2015/12/18.
 */
public class TestKeyczar {
    private static final String TEST_DATA = "./testdata";
    private static String input = "This is some test data";

    public static void main(String ... args)throws Exception{

         Encrypter publicKeyEncrypter = new Encrypter(TEST_DATA + "/rsa.public");
         String plantxt = publicKeyEncrypter.encrypt(input);
         System.out.println(plantxt);
    }
}
