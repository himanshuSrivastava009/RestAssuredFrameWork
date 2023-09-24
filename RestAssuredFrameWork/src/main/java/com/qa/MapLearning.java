package com.qa;

import java.util.*;
public class MapLearning {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("himanshu", 31);
        map.put("swati", 30);

        System.out.println(map);
//to get values
     Collection<Integer> values =  map.values();
        System.out.println(values);


        //using keySet
      Set<String> set  = map.keySet();
      for (String val: set){

          System.out.println(val);
      }

      //entryset

       Set<Map.Entry<String, Integer>> entry = map.entrySet();
        for (Map.Entry<String, Integer> ent: entry) {

            System.out.println(ent.getKey() +"-----" +ent.getValue());
        }
    }
}
