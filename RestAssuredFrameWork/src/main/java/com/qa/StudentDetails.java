package com.qa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentDetails  {


    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Himanshu", 99));
        students.add(new Student("venkat", 200));
        students.add(new Student("Syam", 150));

        Student stu = new Student();
        Comparator<Student> comp = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

                if(o1.getMarks()> o2.getMarks()){
                    return -1;
                }
                else {
                    return 1;
                }
            }
        };
        Collections.sort(students);

        for (Student studs: students)

            System.out.println(studs);



    }

}
