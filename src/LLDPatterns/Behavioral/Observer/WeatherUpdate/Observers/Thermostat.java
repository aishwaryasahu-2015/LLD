package LLDPatterns.Behavioral.Observer.WeatherUpdate.Observers;

import LLDPatterns.Behavioral.Observer.WeatherUpdate.Observer;

public class Thermostat implements Observer {
    private String weather;

    public void display() {
        System.out.println("Weather in Thermostat Display: " + this.weather);
    }

    public void update(String weather) {
        this.weather = weather;
        display();
    }
}
