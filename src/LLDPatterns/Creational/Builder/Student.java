package LLDPatterns.Creational.Builder;

import lombok.NonNull;

import java.util.List;

public class Student {

    @NonNull
    Integer rollNumber;
    int age;
    String name;
    String fatherName;
    String motherName;
    List<String> subjects;

    public Student(StudentBuilder builder){
        this.rollNumber = builder.rollNumber;
        this.name = builder.name;
        this.age = builder.age;
        this.fatherName = builder.fatherName;;
        this.motherName = builder.motherName;
        this.subjects = builder.subjects;
    }

    public String toString(){
        return "rollNumber: " + this.rollNumber +
                " age: " + this.age +
                " name: " + this.name +
                " fatherName: " + this.fatherName +
                " motherName: " + this.motherName +
                " subjects: " + this.subjects.get(0) + ", " + this.subjects.get(1) + ", " + this.subjects.get(2);

    }
}
