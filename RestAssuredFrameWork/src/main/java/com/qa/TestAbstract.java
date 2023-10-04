package com.qa;

public class TestAbstract extends    Test{

    @Override
    public void add() {

    }

    @Override
    public void sub() {

    }

    public static void main(String[] args) {

        Test t = new TestAbstract();
      int y =   t.x;
       y =20;

        System.out.println(t.x);
        System.out.println(y);


        System.out.println(t.testSum(y));
    }
}
