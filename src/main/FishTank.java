package main;

import java.util.ArrayList;
import java.util.List;

public class FishTank {
   private int volumeInLiter;
   private List<Fish> fishes = new ArrayList<>();
   
   public FishTank(int volumeInLiter){
       this.volumeInLiter = volumeInLiter;
   }

   public int getVolumeInLiter() {
       return this.volumeInLiter;
   }

   public void addFish(Fish fish){
       this.fishes.add(fish);
   }

   public int getNumberOfFish(){
       return this.fishes.size();
   }
}
