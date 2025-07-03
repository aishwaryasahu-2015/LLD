package LLDPatterns.Creational.Builder;

public class Director {
    StudentBuilder studentBuilder;

    Director(StudentBuilder studentBuilder){
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent(int studentEnrolled){
        if(studentBuilder instanceof EngineerStudentBuilder){
            return createEngineeringStudent(studentEnrolled);
        }else if(studentBuilder instanceof MBAStudentBuilder){
            return createMbaStudent(studentEnrolled);
        }
        return null;
    }

    private Student createEngineeringStudent(int studentEnrolled){
        return this.studentBuilder.setRollNumber(studentEnrolled).setAge(22).setName("abc").setSubjects().build();
    }

    private Student createMbaStudent(int studentEnrolled){
        return this.studentBuilder.setRollNumber(studentEnrolled).setAge(21).setName("abc").setSubjects().setFatherName("abc1").setMotherName("abc2").build();
    }
}
