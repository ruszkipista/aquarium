package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import main.Fish;
import main.FishTank;
import main.TreasureChest;

public class AppTest {
    int TANK_CAPACITY = 240;
    double BIG_FISH = 11;

    @Test
    public void createFishTankWith240Lcapacity(){
        FishTank tank = new FishTank(TANK_CAPACITY, BIG_FISH);
        assertEquals(TANK_CAPACITY, tank.getVolumeInLiter());
        assertEquals(BIG_FISH, tank.getBigFishLimitInGram(), 0);
    }

    @Test
    public void createConcreteFish(){
        Fish fish = new Carp("Pontyi", 1, "silver");
        assertEquals("Pontyi", fish.getName());
        assertEquals(1, fish.getWeightInGram(), 0);
        assertEquals("silver", fish.getColor());
    }

    @Test
    public void addFishToTank(){
        FishTank tank = new FishTank(TANK_CAPACITY, BIG_FISH);
        assertEquals(0, tank.getNumberOfFish());
        Fish fish1 = new Carp("Pontyi", 1, "silver");
        tank.addFish(fish1);
        assertEquals(1, tank.getNumberOfFish());
        Fish fish2 = new Carp("Potty", 2, "orange");
        tank.addFish(fish2);
        assertEquals(2, tank.getNumberOfFish());
    }

    @Test
    public void removeBigFishFromTank(){
        FishTank tank = new FishTank(TANK_CAPACITY, BIG_FISH);
        tank.addFish(new Carp("big1", BIG_FISH, ""));
        tank.addFish(new Carp("small", 2, ""));
        tank.addFish(new Carp("big2", BIG_FISH+1, ""));
        assertEquals(3, tank.getNumberOfFish());
        tank.removeFish();
        assertEquals(1, tank.getNumberOfFish());
    }

    @Test
    public void feedFishInTankTwoTimesSoOneFishBecomesBig(){
        FishTank tank = new FishTank(TANK_CAPACITY, 11);
        tank.addFish(new Carp("small1", 1, ""));
        tank.addFish(new Carp("small2", 2, ""));
        tank.feed();
        tank.removeFish();
        assertEquals(2, tank.getNumberOfFish());
        tank.feed();
        tank.removeFish();
        assertEquals(1, tank.getNumberOfFish());
    }

    @Test
    public void addFishAndNonFishToTank(){
        FishTank tank = new FishTank(TANK_CAPACITY, BIG_FISH);
        tank.addFish(new Carp("Fishy", 1, ""));
        tank.addDecoration(new TreasureChest(TreasureChest.Status.OPEN));
        assertEquals(1, tank.getNumberOfFish());
    }  
}
