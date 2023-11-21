package com.qa.utilities;

public class ParentOveridding extends StaticOveridding{

    public  static void display(String str){
        System.out.println(str);
    }


    public int sum(int a , int b){
        return a+b;
    }

    public static void main(String[] args) {

        StaticOveridding p = new ParentOveridding();
        p.display("Himanshu");
    }
}
