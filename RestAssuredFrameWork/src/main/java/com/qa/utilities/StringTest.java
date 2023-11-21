package com.qa.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class StringTest {

    public static void getScondLargestNumber(int[] ar){




    }
    public static void getNumbersUsingStreams(String str){

      char[] ch =  str.toCharArray();
//      str.chars()
//
//              .filter(Character::isDigit).forEach(System.out::println);
      int val =  str.chars()

                .filter(Character::isDigit)
                .mapToObj(Character::getNumericValue)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(val);


    }
    public static void getNumbersFromChar(String str){
       int sum = 0;
        ArrayList<Integer> al = new ArrayList<>();
      char[] ch =  str.toCharArray();
      for (int i=0;i<ch.length;i++) {
        if(Character.isDigit(ch[i])){
           al.add( Character.getNumericValue(ch[i]));
           // al.add((int)ch[i]);
        }
      }
        System.out.println(al);
        for (int i=0;i<al.size();i++) {
            sum = sum + al.get(i);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
       // getNumbersFromChar("ab12c3d4");
        getNumbersUsingStreams("ab12c3d4");
    }
}
