package com.qa;

import java.util.Arrays;
public class Demo4 {
    static void printAllSubstring(String st) {
        int n = st.length();
        for (int len = 1; len < n; len++) {
            for (int s = 0; s <= (n - len); s++) {
                for (int e = s; e <= (s + len) - 1; e++) {
                    System.out.println(st.charAt(e));
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        String s = "tapacademy";
        printAllSubstring(s);
    }
}