package com.qa;

import java.util.ArrayList;
import java.util.Collections;

public class FilterDuplicateElementsFromAnArray {

    public static void main(String[] args) {
        //print as a list

        String[] arr = {"swati","himanshu","saurabh","priti","rajan","nilima","swati","priti"};
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            for(int j=i;j<arr.length-1;j++){

                if(arr[i].equalsIgnoreCase(arr[j+1])){

                    list.add(arr[i]);

                }
            }

        }

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
