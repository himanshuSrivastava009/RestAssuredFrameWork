package com.qa.pojo;

import java.util.HashMap;
import java.util.Map;

public class CountOcc {

//    Input: str = "aabccccddd" ;
//    Output: a2b1c4d3

    public static void countAlpha(String str){

        if(str!=null && str!="") {
            HashMap<Character, Integer> map = new HashMap<>();
            char[] ch = str.toCharArray();
            for (char c : ch) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }

            for (Map.Entry en : map.entrySet()) {

                System.out.print(en.getKey());
                System.out.print(en.getValue());

            }
        }
        else {

            System.out.println("Null value");
        }
    }
    public static void main(String[] args) {

        countAlpha("");

    }

}
