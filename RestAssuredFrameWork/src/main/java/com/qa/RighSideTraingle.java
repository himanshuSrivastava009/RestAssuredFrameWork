package com.qa;

public class RighSideTraingle {

    public static void main(String[] args) {

        int n = 100;
    if(n>=1&&n<=100) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {

                System.out.print("*");
            }
            System.out.println();
        }
    }
    else {
        System.out.println("Out of Range");
    }
    }
}
