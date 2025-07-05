package LLDPatterns.Structural.Bridge.LivingThings;

import LLDPatterns.Structural.Bridge.LivingThings.BreatheImplementationClasses.LandBreatheImplementor;
import LLDPatterns.Structural.Bridge.LivingThings.BreatheImplementationClasses.TreeBreatheImplementor;
import LLDPatterns.Structural.Bridge.LivingThings.BreatheImplementationClasses.WaterBreatheImplementor;
import LLDPatterns.Structural.Bridge.LivingThings.LivingThingsModel.*;

public class Main {
    public static void main(String[] args){
        LivingThings dog = new Dog(new LandBreatheImplementor());
        LivingThings fish = new Fish(new WaterBreatheImplementor());
        LivingThings tree = new Tree(new TreeBreatheImplementor());

        dog.breatheProcess();
        fish.breatheProcess();
        tree.breatheProcess();
    }
}
