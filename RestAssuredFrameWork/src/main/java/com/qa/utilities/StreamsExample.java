package com.qa.utilities;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {

    public static void main(String[] args) {

     String str = "himanshu";
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ch = str.toCharArray();

        for (char c: ch) {

            if(map.containsKey(c)){

                map.put(c,map.get(c)+1);
            }
            else {
                map.put(c,1);
            }
        }


        for (Map.Entry<Character,Integer> m:map.entrySet()) {


                if(m.getValue()==1){
                    System.out.println(m.getKey() + "==" + m.getValue());

        }


        }

        }


    }

