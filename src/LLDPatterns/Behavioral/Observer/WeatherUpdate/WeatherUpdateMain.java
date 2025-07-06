package LLDPatterns.Behavioral.Observer.WeatherUpdate;

import LLDPatterns.Behavioral.Observer.WeatherUpdate.Observables.WeatherStation;
import LLDPatterns.Behavioral.Observer.WeatherUpdate.Observers.PhoneDisplay;
import LLDPatterns.Behavioral.Observer.WeatherUpdate.Observers.TVDisplay;
import LLDPatterns.Behavioral.Observer.WeatherUpdate.Observers.Thermostat;

public class WeatherUpdateMain {
    public static void main(String[] args){
        Observable weatherStation = new WeatherStation();
        Observer phone = new PhoneDisplay();
        Observer thermostat = new Thermostat();
        Observer tv = new TVDisplay();

        weatherStation.addObserver(phone);
        weatherStation.addObserver(thermostat);
        weatherStation.addObserver(tv);

        phone.display();
        thermostat.display();
        tv.display();

        weatherStation.setWeather("14.5 Celsius");
    }
}
