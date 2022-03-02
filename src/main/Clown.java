package main;

public class Clown extends Fish{
    public static double WEIGHT_GAIN_AFTER_FEEDING = 1.0;
    private String colorStripe;

    public Clown(String name, double weightInGram, String colorBody, String colorStripe) {
        super(name, weightInGram, colorBody);
        this.colorStripe = colorStripe;
    }
    
    @Override
    public void feed(){
        super.setWeightInGram(super.getWeightInGram() + Clown.WEIGHT_GAIN_AFTER_FEEDING);
    }

    @Override
    public String status(){
        return super.status() 
             + " with " + this.colorStripe + " stripes";
    }
}
