package LLDPatterns.Creational.Builder;

import java.util.ArrayList;
import java.util.List;

public class College {
    List<Student> EngineeringStudents;
    List<Student> MBAStudents;
    int engineeringStudentsEnrolled;
    int mbaStudentsEnrolled;

    public static void main(String[] args){
        College clg = new College();
        clg.initialize();
        Director engineeringDirector = new Director(new EngineerStudentBuilder());
        Director mbaDirector = new Director(new MBAStudentBuilder());

        Student st1 = engineeringDirector.createStudent(++clg.engineeringStudentsEnrolled);
        Student st2 = mbaDirector.createStudent(++clg.mbaStudentsEnrolled);
        System.out.println(st1);
        System.out.println(st2);

        Student st3 = engineeringDirector.createStudent(++clg.engineeringStudentsEnrolled);
        Student st4 = mbaDirector.createStudent(++clg.mbaStudentsEnrolled);
        System.out.println(st3);
        System.out.println(st4);
    }

    public void initialize(){
        this.engineeringStudentsEnrolled = 0;
        this.mbaStudentsEnrolled = 0;
        this.EngineeringStudents = new ArrayList<>();
        this.MBAStudents = new ArrayList<>();
    }
}
