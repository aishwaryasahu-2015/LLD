package LLDPatterns.Structural.Composite.FileSystem.Solution1CompositeDesign;

public class Main {

    public static void main(String[] args){
        Directory dir1 = new Directory("FileSystemRoot");
        Directory dir2 = new Directory("FileSystem1");
        Directory dir3 = new Directory("FileSystem2");
        Directory dir4 = new Directory("FileSystem1.1");
        Directory dir5 = new Directory("FileSystem1.2");

        File file1 = new File("File1");
        File file2 = new File("File1");
        File file3 = new File("File1");

        dir2.add(dir4);
        dir3.add(dir5);
        dir2.add(file2);
        dir3.add(file3);
        dir1.add(file1);
        dir1.add(dir2);
        dir1.add(dir3);

        dir1.ls();
    }
}
