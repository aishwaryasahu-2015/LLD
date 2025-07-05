package LLDPatterns.Structural.Bridge.LivingThings.LivingThingsModel;

import LLDPatterns.Structural.Bridge.LivingThings.BreatheImplementationClasses.BreatheImplementor;

public abstract class LivingThings {
    BreatheImplementor breatheImplementor;

    public LivingThings(BreatheImplementor breatheImplementor){
        this.breatheImplementor = breatheImplementor;
    }

    public abstract void breatheProcess();
}

