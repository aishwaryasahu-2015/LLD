package LLDPatterns.Creational.Singleton.LazyInitialization;

public class DBConnection {
    //Initialize the instance when needed instead of when the application is fired up
    private static DBConnection connObject;

    private DBConnection(){
        System.out.println("DBConnection Initialized");
    }

    public static DBConnection getInstance(){
        System.out.println("DBConnection instance requested.");
        if(connObject == null){
            connObject = new DBConnection();
        }
        return connObject;
    }
}
//Problem????
//1. If there are multiple threads requested DBConnection for the first time multiple instance will be created, so not thread safe.
//2. Exception Handling Difficulty: In lazy initialization, if the constructor throws an exception, it's harder to recover or retry later.
//3.
//Solution: Synchronized and Double Locking singleton pattern