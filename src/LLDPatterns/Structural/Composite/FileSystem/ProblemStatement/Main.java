package LLDPatterns.Structural.Composite.FileSystem.ProblemStatement;

public class Main {

    public static void main(String[] args){
        Directory dir1 = new Directory("FileSystem");
        Directory dir2 = new Directory("Directory1");
        Directory dir3 = new Directory("Directory2");
        Directory dir4 = new Directory("Directory1.1");
        Directory dir5 = new Directory("Directory2.1");

        File file1 = new File("File1");
        File file2 = new File("File2");
        File file3 = new File("File3");

        dir2.add(dir4);
        dir2.add(file2);
        dir3.add(dir5);
        dir1.add(file1);
        dir1.add(file3);
        dir1.add(dir2);
        dir1.add(dir3);

        dir1.ls();
    }
}
