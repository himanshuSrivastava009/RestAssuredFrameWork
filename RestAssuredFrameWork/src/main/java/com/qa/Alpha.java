package com.qa;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Alpha {
    public static void main(String[] args) {
        Customer customer = new Customer("Alex",
                12345678, 20000);
        String path =
                "/Users/swati/Desktop/RestAssureFrameWork/RestAssuredFrameWork/RestAssuredFrameWork/src/main/java/com/qa/test.txt";
        FileOutputStream fos = null;
        try {
            fos = new
                    FileOutputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectOutputStream oos = null;
        try {
            oos = new
                    ObjectOutputStream(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            oos.writeObject(customer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

