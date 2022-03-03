package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import main.Clown;
import main.Fish;
import main.FishTank;
import main.Kong;
import main.Tang;
import main.TreasureChest;
import main.Water;

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
    public void addWaterToTank(){
        FishTank tank = new FishTank(TANK_CAPACITY, BIG_FISH);
        tank.addWater(new Water(100));
        assertEquals(100, tank.getWaterContentInLiter(), 0);
        tank.addWater(new Water(120));
        assertEquals(220, tank.getWaterContentInLiter(), 0);
        assertEquals("Water: 220.0 Liter\n", tank.getStatus());
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
        tank.addWater(new Water(220));
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
        tank.addWater(new Water(220));
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
        tank.addWater(new Water(220));
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
        tank.addWater(new Water(220));
        tank.addFish(new Carp("Fishy", 1, ""));
        tank.addDecoration(new TreasureChest(TreasureChest.Status.OPEN));
        assertEquals(1, tank.getNumberOfFish());
    }

    @Test
    public void testTreasureChestLidStatuses(){
        TreasureChest chest = new TreasureChest(TreasureChest.Status.OPEN);
        assertFalse(chest.isClosed());
        chest.openLid();
        assertFalse(chest.isClosed());
        chest.closeLid();
        assertTrue(chest.isClosed());
        chest.closeLid();
        assertTrue(chest.isClosed());
        chest.openLid();
        assertFalse(chest.isClosed());
    }

    @Test
    public void addFishAndTreasureChestToTankAndGetStatus(){
        FishTank tank = new FishTank(TANK_CAPACITY, BIG_FISH);
        tank.addWater(new Water(220));
        tank.addFish(new Carp("Small", 1, "red"));
        tank.addFish(new Carp("Big",  14, "blue"));
        tank.addDecoration(new TreasureChest(TreasureChest.Status.OPEN));
        assertEquals("Water: 220.0 Liter\n"
                    +"Small, weight: 1, color: red\n"
                    +"Big, weight: 14, color: blue\n"
                    +"Treasure Chest - its lid is open\n",
                     tank.getStatus());
    }

    @Test
    public void testKongWeightGainAfterTwoFeeding(){
        Kong kong = new Kong("KingKong", 3, "red");
        assertEquals(3, kong.getWeightInGram(), 0);
        kong.feed();
        assertEquals(5, kong.getWeightInGram(), 0);
        kong.feed();
        assertEquals("KingKong, weight: 7, color: red", kong.status());
    }

    @Test
    public void testClownWeightGainAfterTwoFeeding(){
        Clown clown = new Clown("Clownfish", 2, "orange", "white");
        assertEquals(2, clown.getWeightInGram(), 0);
        clown.feed();
        assertEquals(3, clown.getWeightInGram(), 0);
        clown.feed();
        assertEquals("Clownfish, weight: 4, color: orange with white stripes",
                      clown.status());
    }

    @Test
    public void testTangWeightGainAfterTwoFeeding(){
        Tang tang = new Tang("Tangfish", 5, "blue", true);
        assertEquals(5, tang.getWeightInGram(), 0);
        tang.feed();
        assertEquals(6, tang.getWeightInGram(), 0);
        tang.feed();
        assertEquals("Tangfish, weight: 7, color: blue, short-term memory loss: true",
                      tang.status());
    }
}
