package com.qa.utilities;

public class RandomEmailGen {

    public static String randomEmailGenerator(){

        return "api"+System.currentTimeMillis()+"@api.com";
    }
}
