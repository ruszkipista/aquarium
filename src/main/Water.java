package main;

public class Water implements Tankable {
    private double volumeInLiter;

    public Water(double volumeInLiter){
        this.volumeInLiter = volumeInLiter;
    }

    public void add(Water water){
        this.volumeInLiter += water.volumeInLiter;
        water.volumeInLiter = 0.0;
    }

    public double getVolumeInLiter(){
        return volumeInLiter;
    }

    public String status(){
        return "Water: " + volumeInLiter + " Liter";
    }
}
