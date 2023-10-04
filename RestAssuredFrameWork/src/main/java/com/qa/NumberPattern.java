package com.qa;

import java.util.Scanner;

public class NumberPattern {

    static int j = 1;
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();


            for( j=1;j<=n;j++) {
                if (j < 10) {
                    System.out.print("0" + j + " ");
                    if (j % 5 == 0) {

                        System.out.println();
                    }
                }
                else {
                    System.out.print(j + " ");
                    if (j % 5 == 0) {

                        System.out.println();
                    }
                }
            }

            System.out.println();

        }

        }

