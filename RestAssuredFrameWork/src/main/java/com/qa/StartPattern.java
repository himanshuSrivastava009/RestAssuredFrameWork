package com.qa;

public class StartPattern {

    public static void main(String[] args) {

        int n = 200;
    /*
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                System.out.print("  " + "*");
            }
            System.out.println();
        }
*/
        if (n >= 1  && n <= 100) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n - i; j++) {

                    System.out.print(" ");
                }
                for (int k = 1; k <= i; k++) {

                    System.out.print("* ");
                }
                System.out.println();
            }
        } else {

            System.out.println("Out of Range");
        }

    }
    }
