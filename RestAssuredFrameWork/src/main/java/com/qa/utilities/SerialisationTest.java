package com.qa.utilities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
class Student implements Serializable {

    @JsonProperty("roolNumber")
    private int roolNumber;

    @JsonProperty("name")
    private String name;
}

public class SerialisationTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student st = Student.builder()
                .name("Himanshu")
                .roolNumber(10)
                .build();

        FileOutputStream fos = new FileOutputStream("E:\\FilrWithRestAssured\\RestAssuredFrameWork\\testSer.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(st);
        oos.close();

        FileInputStream fis = new FileInputStream("E:\\FilrWithRestAssured\\RestAssuredFrameWork\\testSer.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student st1 = (Student) ois.readObject();
        ois.close();
        System.out.println(st1.getName());
    }


}
