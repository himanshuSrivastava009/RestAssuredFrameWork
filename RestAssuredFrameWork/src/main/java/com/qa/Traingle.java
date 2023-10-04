package com.qa;

public class Traingle {

    public static void main(String[] args) {
        int n = 10;
        if(n>=1&&n<=100){

            for(int i=1;i<=n;i++){
                for(int j=1;j<=i;j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
