package LLDPatterns.Creational.Singleton.LazyInitialization;

public class Main {

    public static void main(String args[]){
        System.out.println("This is an example of Singleton Lazy Initialization");

        DBConnection connObject = DBConnection.getInstance();
        System.out.println(connObject.toString());
    }
}
