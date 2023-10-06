package com.qa;

public class StringSort {

    public static void main(String[] args) {

        int[] arr = {2,80,10,90,100,200,0,200};
        int largest=Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){

            if(arr[i]>largest){
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i]>secondLargest && arr[i]!=largest) {

                secondLargest = arr[i];
            }
        }
        System.out.println(largest);
        System.out.println(secondLargest);
    }
}
