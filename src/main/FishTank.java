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

    public int getNumberOfFish(){
        return this.content.size();
    }

    public void removeFish(){
        for (Iterator<Tankable> iterator = this.content.iterator(); iterator.hasNext(); ) {
            Tankable item = iterator.next();
            if (Fish.class.isInstance(item))
                if (((Fish)item).getWeightInGram() >= this.bigFishLimitInGram)
                    iterator.remove();
        }
    }

    public void feed(){
        for (Tankable item : this.content)
            if (Feedable.class.isInstance(item))
                ((Feedable)item).feed();
    }
}
