package com.qa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class JavaCodingConcepts {

    public static void main(String[] args) {

        HashMap<String , String> map = new HashMap<>();
        map.put("himanshu", "kumar");
        map.put("swati", "srivastava");

       Iterator<Map.Entry<String, String>> itr=  map.entrySet().iterator();

       while (itr.hasNext())
       {
        Map.Entry<String,String> entry  =  itr.next();
           System.out.println(entry.getKey());
         //  System.out.println(itr.next().getKey() + itr.next().getValue());
       }
    }
}
