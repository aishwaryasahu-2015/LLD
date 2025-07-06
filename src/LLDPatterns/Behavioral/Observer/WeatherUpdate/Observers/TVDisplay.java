package LLDPatterns.Behavioral.Observer.WeatherUpdate.Observers;

import LLDPatterns.Behavioral.Observer.WeatherUpdate.Observer;

public class TVDisplay implements Observer {
    private String weather;
    public void display() {
        System.out.println("weather in TVDisplay: " + this.weather);
    }

    public void update(String weather) {
        this.weather = weather;
        display();
    }
}
