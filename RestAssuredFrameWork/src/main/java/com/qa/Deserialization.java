package com.qa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String path =
                "/Users/swati/Desktop/RestAssureFrameWork/RestAssuredFrameWork/RestAssuredFrameWork/src/main/java/com/qa/test.txt";

        FileInputStream fis=null;
        ObjectInputStream ois =null;
        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

      Customer customer = (Customer) ois.readObject();

        System.out.println(customer.getName());
    }
}
