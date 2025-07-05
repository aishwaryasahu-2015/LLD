package LLDPatterns.Structural.Bridge.LivingThings.BreatheImplementationClasses;

public class AirBreatheImplementor implements BreatheImplementor {
    @Override
    public void breathe() {
        System.out.println("Breathes via Narse");
    }
}
