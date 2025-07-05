package LLDPatterns.Structural.Adapter.Client;

import LLDPatterns.Structural.Adapter.Adaptee.WeightMachineForBaby;
import LLDPatterns.Structural.Adapter.Adapter.WeightMachineAdapter;
import LLDPatterns.Structural.Adapter.Adapter.WeightMachineAdapterImpl;

public class Main {

    public static void main(String[] args){
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBaby());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
