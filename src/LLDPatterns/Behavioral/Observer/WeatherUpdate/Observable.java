package LLDPatterns.Behavioral.Observer.WeatherUpdate;

public interface Observable {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
    public void setWeather(String weather);
}
