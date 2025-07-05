package LLDPatterns.Structural.Bridge.LivingThings.BreatheImplementationClasses;

public class TreeBreatheImplementor implements BreatheImplementor {
    @Override
    public void breathe() {
        System.out.println("Breathe via leaves");
    }
}
