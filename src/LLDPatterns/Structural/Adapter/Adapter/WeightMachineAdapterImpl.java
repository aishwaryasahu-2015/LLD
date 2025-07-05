package LLDPatterns.Structural.Adapter.Adapter;

import LLDPatterns.Structural.Adapter.Adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter{
    WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine){
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKg(){
        return this.weightMachine.getWeightInPound() * .45;
    };
}
