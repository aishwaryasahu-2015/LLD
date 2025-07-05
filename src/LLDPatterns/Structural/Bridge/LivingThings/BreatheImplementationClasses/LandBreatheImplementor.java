package LLDPatterns.Structural.Bridge.LivingThings.BreatheImplementationClasses;

public class LandBreatheImplementor implements BreatheImplementor {
    @Override
    public void breathe() {
        System.out.println("Breathes via Nose");
    }
}
