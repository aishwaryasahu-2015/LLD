package LLDPatterns.Structural.Composite.FileSystem.Solution1CompositeDesign;

public class File implements FileSystem{
    String fileName;

    public File(String name){
        this.fileName = name;
    }

    @Override
    public void ls() {
        System.out.println("Filename: " + this.fileName);
    }
}
