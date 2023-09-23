package com.qa.utilities;

import java.util.Random;

public class RandomUserIDGen {

    public static int generateUserID(){


        Random random = new Random();
        int min = 10000; // Minimum 5-digit number
        int max = 99999; // Maximum 5-digit number

        int randomNumber = random.nextInt((max - min) + 1) + min;
        System.out.println("Random 5-digit number: " + randomNumber);
        return  randomNumber;
    }

    public static void main(String[] args) {
    }
}
