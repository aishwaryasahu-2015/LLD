package LLDPractice.Uber;

public class Util {
    public int getDistance(Location start, Location end){
        return (int) Math.ceil(Math.pow(Math.pow(end.latitude - start.latitude, 2) + Math.pow(end.longitude - start.longitude, 2), 0.5));
    }
}
