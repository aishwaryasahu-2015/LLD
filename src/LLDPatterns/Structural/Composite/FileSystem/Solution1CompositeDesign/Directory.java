package LLDPatterns.Structural.Composite.FileSystem.Solution1CompositeDesign;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{
    String directoryName;
    List<FileSystem> fileSystemList;

    public Directory(String name){
        this.directoryName = name;
        this.fileSystemList = new ArrayList<>();
    }

    public void add(FileSystem fileSystem){
        this.fileSystemList.add(fileSystem);
    }

    @Override
    public void ls() {
        System.out.println("Directory Name: " + this.directoryName);
        for(FileSystem fileSystemObj: this.fileSystemList){
            fileSystemObj.ls();
        }
    }
}
