package LLDPatterns.Creational.Builder;

import java.util.ArrayList;
import java.util.Arrays;

public class MBAStudentBuilder extends StudentBuilder{
    @Override
    public StudentBuilder setSubjects() {
        this.subjects = new ArrayList<>();
        this.subjects.addAll(Arrays.asList("Finance", "Economics", "Entrepreneurship"));
        return this;
    }
}
