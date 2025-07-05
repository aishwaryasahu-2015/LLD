package LLDPatterns.Structural.Composite.FileSystem.ProblemStatement;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    String directoryName;
    List<Object> objectsList;

    public Directory(String name){
        this.directoryName = name;
        this.objectsList = new ArrayList<>();
    }

    public void add(Object object){
        this.objectsList.add(object);
    }

    public void ls(){
        System.out.println("Directory Name: " + directoryName);
        for(Object obj: objectsList){
            if(obj instanceof File){
                ((File) obj).ls();
            }else if(obj instanceof Directory){
                ((Directory) obj).ls();
            }
        }
    }
}
