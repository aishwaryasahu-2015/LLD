package LLDPatterns.Creational.Builder;

import java.util.ArrayList;
import java.util.Arrays;

public class EngineerStudentBuilder extends StudentBuilder{
    @Override
    public StudentBuilder setSubjects() {
        this.subjects = new ArrayList<>();
        this.subjects.addAll(Arrays.asList("DSA", "Operating System", "Computer Network", "DBMS"));
        return this;
    }
}
