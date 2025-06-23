package LLDPatterns.Creational.Singleton.Synchronized;

public class DBConnection {
    private static DBConnection connObject;

    private DBConnection(){

    }

    synchronized public static DBConnection getInstance(){
        if(connObject == null)
            connObject = new DBConnection();
        return connObject;
    }
}
//Method-Level synchronized
//So the lock status is stored in:
//this object's header for instance methods.
//Class object’s header for static methods.



//Synchronized Lock is very expensive if multiple threads tries to access it, Therefore double lock is used.
