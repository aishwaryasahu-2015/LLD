package LLDPatterns.Creational.Singleton.DoubleLocking;

public class Main {
    public static void main(String args[]){
        System.out.println("Double Locking : Thread Safe and Efficient");

        DBConnection connObject = DBConnection.getInstance();
    }
}
