package LLDPatterns.Structural.Bridge.LivingThings.BreatheImplementationClasses;

public class WaterBreatheImplementor implements BreatheImplementor{
    @Override
    public void breathe() {
        System.out.println("Breathe via gills");
    }
}
