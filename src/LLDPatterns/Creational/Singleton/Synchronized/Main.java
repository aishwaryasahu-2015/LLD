package LLDPatterns.Creational.Singleton.Synchronized;

public class Main {

    public static void main(String args[]){
        System.out.println("The Synchronized DBConnection is getting establish.");

        DBConnection connObject = DBConnection.getInstance();
    }
}

//Expensive
