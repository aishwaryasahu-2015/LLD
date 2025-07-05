package LLDPatterns.Structural.Bridge.LivingThings.LivingThingsModel;

import LLDPatterns.Structural.Bridge.LivingThings.BreatheImplementationClasses.BreatheImplementor;

public class Tree extends LivingThings {
    public Tree(BreatheImplementor breatheImplementor) {
        super(breatheImplementor);
    }

    @Override
    public void breatheProcess() {
        breatheImplementor.breathe();
    }
}
