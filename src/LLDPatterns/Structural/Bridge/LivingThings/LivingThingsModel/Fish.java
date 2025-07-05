package LLDPatterns.Structural.Bridge.LivingThings.LivingThingsModel;

import LLDPatterns.Structural.Bridge.LivingThings.BreatheImplementationClasses.BreatheImplementor;

public class Fish extends LivingThings {
    public Fish(BreatheImplementor breatheImplementor) {
        super(breatheImplementor);
    }

    @Override
    public void breatheProcess() {
        breatheImplementor.breathe();
    }
}
