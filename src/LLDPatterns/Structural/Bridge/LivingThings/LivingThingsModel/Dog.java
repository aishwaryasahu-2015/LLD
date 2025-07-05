package LLDPatterns.Structural.Bridge.LivingThings.LivingThingsModel;

import LLDPatterns.Structural.Bridge.LivingThings.BreatheImplementationClasses.BreatheImplementor;

public class Dog extends LivingThings {
    public Dog(BreatheImplementor breatheImplementor) {
        super(breatheImplementor);
    }

    @Override
    public void breatheProcess() {
        breatheImplementor.breathe();
    }
}
