package com.qa;

public class SquarePatternWithMultiple {

    public static void main(String[] args) {
        int n = 5;
        int count = 1;
        if(n>=1&&n<=100) {
            for (int i = 1; i <= n; i++) {

                for (int j = 1; j <= n; j++) {
                    if (count < 10) {
                        System.out.print("0");
                    }
                    System.out.print(count+i + " ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Out of Range");
        }
    }
}
