package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FishTank {
   private int volumeInLiter;
   private double bigFishLimitInGram;

   private List<Fish> fishes = new ArrayList<>();
   
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
       this.fishes.add(fish);
   }

   public int getNumberOfFish(){
       return this.fishes.size();
   }

   public void removeFish(){
        for (Iterator<Fish> iterator = this.fishes.iterator(); iterator.hasNext(); ) {
            Fish fish = iterator.next();
            if (fish.getWeightInGram() >= this.bigFishLimitInGram)
                iterator.remove();
        }
    }
}
