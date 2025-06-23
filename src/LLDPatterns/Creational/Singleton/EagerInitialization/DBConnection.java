package LLDPatterns.Creational.Singleton.EagerInitialization;

public class DBConnection {
    //due to static field the object becomes property specific to class rather than independent object.
    // This creates instance the moment application is fired up
    public static DBConnection connObject = new DBConnection();

    //make private constructor which can be accessed during above static initialization
    private DBConnection(){
        System.out.println("DBConnection Initialized");
    }

    //expose the class to be accessed from other class in the project
    public static DBConnection getInstance(){
        System.out.println("DBConnection instance requested.");
        return connObject;
    }
}
