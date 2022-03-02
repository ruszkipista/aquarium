package main;

public class Kong extends Fish {
    public static double WEIGHT_GAIN_AFTER_FEEDING = 2.0;

    public Kong(String name, double weightInGram, String color) {
        super(name, weightInGram, color);
    }
    
    @Override
    public void feed(){
        super.setWeightInGram(super.getWeightInGram() + Kong.WEIGHT_GAIN_AFTER_FEEDING);
    }
}
