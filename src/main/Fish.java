package main;

public abstract class Fish implements Feedable, Tankable {
    private String name;
    private double weightInGram;
    private String color;

    public Fish(String name, double weightInGram, String color){
        this.name = name;
        this.weightInGram = weightInGram;
        this.color = color;
    }

    public String getName() {
        return name;
    }
    public double getWeightInGram() {
        return weightInGram;
    }
    public void setWeightInGram(double weightInGram){
        this.weightInGram = weightInGram;
    }
    public String getColor() {
        return color;
    }

}
