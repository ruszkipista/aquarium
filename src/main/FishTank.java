package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FishTank {
    private int volumeInLiter;
    private double bigFishLimitInGram;

    private List<Tankable> content = new ArrayList<>();

    public FishTank(int volumeInLiter, double bigFishLimitInGram){
        this.volumeInLiter = volumeInLiter;
        this.bigFishLimitInGram = bigFishLimitInGram;
    }

    public int getVolumeInLiter() {
        return this.volumeInLiter;
    }
    public double getBigFishLimitInGram(){
        return this.bigFishLimitInGram;
    }

    public void addWater(Water water) throws WaterOverflowException{
        double waterContent = 0.0;
        boolean foundWater = false;
        for (Tankable item : content)
            if (Water.class.isInstance(item)) {
                foundWater = true;
                ((Water)item).add(water);
                waterContent += ((Water)item).getVolumeInLiter();
            }
        if (!foundWater){
            content.add(water);
            waterContent = water.getVolumeInLiter();
        }
        if (waterContent > this.volumeInLiter)
            throw new WaterOverflowException("Water poured into tank has overflown by "
                                            +(waterContent-this.volumeInLiter)+" Liter");
    }

    public double getWaterContentInLiter(){
        double waterContent = 0.0;
        for (Tankable item : content)
            if (Water.class.isInstance(item)) 
                waterContent += ((Water)item).getVolumeInLiter();
        return waterContent;
    }

    public void addFish(Fish fish){
        this.content.add(fish);
    }

    public void addDecoration(Tankable obj){
        this.content.add(obj);
    }

    public int getNumberOfFish(){
        int numberOfFish = 0;
        for (Tankable item : content)
            if (Fish.class.isInstance(item)) numberOfFish++;
        return numberOfFish;
    }

    public void removeFish(){
        for (Iterator<Tankable> iterator = content.iterator(); iterator.hasNext(); ) {
            Tankable item = iterator.next();
            if (Fish.class.isInstance(item))
                if (((Fish)item).getWeightInGram() >= bigFishLimitInGram)
                    iterator.remove();
        }
    }

    public void feed(){
        for (Tankable item : content)
            if (Feedable.class.isInstance(item))
                ((Feedable)item).feed();
    }

    public String getStatus(){
        String status="";
        for (Tankable item : content)
            status += item.status() + "\n";
        return status;
    }
}
