package LLDPatterns.Creational.Singleton.EagerInitialization;

public class Main {

    public static void main(String args[]){
        System.out.println("Please initialize DBConnection");

        DBConnection connObject = DBConnection.getInstance();
        System.out.println(connObject.toString());
    }

}
