package com.qa;

public class HollowHillPattern {

    public static void main(String[] args) {

        int n=20;
        int i,j,k;
        for( i=1;i<=n;i++){
            for( j=i;j<=n;j++){
                System.out.print("  ");
            }
            for( k=1;k<=i;k++){
                if(i==n||k==i||i+k==n+1) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            for(int l=1;l<i;l++){
                if(i==n||l==i||l+i==n+1) {
                    System.out.print("* ");
                }
                else {
                    System.out.println("  ");
                }

            }
            System.out.println();
        }
    }
}
