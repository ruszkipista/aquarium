package main;

public class Tang extends Fish {
    public static double WEIGHT_GAIN_AFTER_FEEDING = 1.0;
    private boolean isAmnesiac;

    public Tang(String name, double weightInGram, String color, boolean isAmnesiac) {
        super(name, weightInGram, color);
        this.isAmnesiac = isAmnesiac;
    }
    
    @Override
    public void feed(){
        super.setWeightInGram(super.getWeightInGram() + Tang.WEIGHT_GAIN_AFTER_FEEDING);
    }

    @Override
    public String status(){
        return super.status() 
             + ", short-term memory loss: " + this.isAmnesiac;
    }
}
