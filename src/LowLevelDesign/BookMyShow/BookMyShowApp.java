package LowLevelDesign.BookMyShow;

import LowLevelDesign.BookMyShow.Enums.CityName;

import java.util.HashMap;
import java.util.List;

public class BookMyShowApp {
    AdminPortal adminPortal;
    HashMap<String, List<Ticket>> userHistory;

    public BookMyShowApp(){
        this.adminPortal = new AdminPortal();
    }
    public static void main(String[] args){
        BookMyShowApp bookMyShowApp = new BookMyShowApp();
        bookMyShowApp.init();
    }

    public void init(){
        this.adminPortal.addCity(CityName.BANGALORE);
        this.adminPortal.addCity(CityName.DELHI);
        this.adminPortal.addCity(CityName.KOLKATA);
        this.adminPortal.addCity(CityName.PUNE);
        this.adminPortal.addCity(CityName.MUMBAI);
    }

}
