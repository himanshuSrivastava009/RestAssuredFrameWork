package com.qa;

public class NumberTraingle {

    public static void main(String[] args) {

        int n = 10;
        if(n>=1&&n<=100) {
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= i; j++) {

                    System.out.print(j);
                }
                System.out.println();
            }
        }
        else {
            System.out.println("Out of range");
        }
    }
}
