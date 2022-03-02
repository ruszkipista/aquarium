package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import main.Fish;
import main.FishTank;

public class AppTest {
    @Test
    public void createFishTankWith240Lcapacity(){
        FishTank tank = new FishTank(240);
        assertEquals(240, tank.getVolumeInLiter());
    }

    @Test
    public void createConcreteFish(){
        Fish fish = new Carp("Pontyi", 1, "silver");
        assertEquals("Pontyi", fish.getName());
        assertEquals(1, fish.getWeightInGram(), 0);
        assertEquals("silver", fish.getColor());
    }

    @Test
    public void addOneFishToTank(){
        FishTank tank = new FishTank(240);
        assertEquals(0, tank.getNumberOfFish());
        Fish fish = new Carp("Pontyi", 1, "silver");
        tank.addFish(fish);
        assertEquals(1, tank.getNumberOfFish());
    }
}
