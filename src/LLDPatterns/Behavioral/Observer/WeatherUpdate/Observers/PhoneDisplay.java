package LLDPatterns.Behavioral.Observer.WeatherUpdate.Observers;

import LLDPatterns.Behavioral.Observer.WeatherUpdate.Observer;

public class PhoneDisplay implements Observer {
    private String weather;

    public void display() {
        System.out.println("Display Weather in PhoneDisplay: " + this.weather);
    }

    public void update(String weather) {
        this.weather = weather;
        display();
    }
}
