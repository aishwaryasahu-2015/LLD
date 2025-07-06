package LLDPatterns.Behavioral.Observer.WeatherUpdate.Observables;

import LLDPatterns.Behavioral.Observer.WeatherUpdate.Observable;
import LLDPatterns.Behavioral.Observer.WeatherUpdate.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Observable {
    private String weather;
    private List<Observer> observers;

    public WeatherStation(){
         this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        for(Observer observer: this.observers){
            observer.update(this.weather);
        }
    }

    public void setWeather(String weather){
        this.weather = weather;
        notifyObservers();
    }
}
