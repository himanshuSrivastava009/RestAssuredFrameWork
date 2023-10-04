package com.qa;

public class Student implements Comparable<Student> {

    private String name;
    private int marks;

    public Student() {
    }

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name = '" + name + '\'' +
                ", marks = " + marks +
                '}';
    }


    @Override
    public int compareTo(Student that) {
        if(this.getMarks()> that.getMarks()) {
            return -1;
        }
            else{
            return 1;
            }
        }
    }

