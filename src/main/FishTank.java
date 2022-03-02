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

    public void addFish(Fish fish){
        this.content.add(fish);
    }

    public void addDecoration(Tankable obj){
        this.content.add(obj);
    }

    public int getNumberOfFish(){
        int numberOfFish = 0;
        for (Tankable item : content)
            if (isFish(item)) numberOfFish++;
        return numberOfFish;
    }

    private boolean isFish(Tankable item){
        return Fish.class.isInstance(item);
    }

    public void removeFish(){
        for (Iterator<Tankable> iterator = content.iterator(); iterator.hasNext(); ) {
            Tankable item = iterator.next();
            if (isFish(item))
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
