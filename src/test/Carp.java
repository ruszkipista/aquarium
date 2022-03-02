package test;

import main.Fish;

public class Carp extends Fish{
    private static double WEIGHT_GAIN_AFTER_FEEDING = 4.5;

    public Carp(String name, double weightInGram, String color){
        super(name, weightInGram, color);
    }

    @Override
    public void feed(){
        super.setWeightInGram(super.getWeightInGram() + Carp.WEIGHT_GAIN_AFTER_FEEDING);
    }
}
