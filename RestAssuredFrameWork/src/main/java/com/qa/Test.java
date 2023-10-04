package com.qa;

abstract class  Test {


    public Test(){

        System.out.println("Abstract Class constructor");
    }

    public static int x = 10;
    public abstract void add();
    public abstract void sub();

    public int testSum(int y){
        return this.x+y;
    }
}
