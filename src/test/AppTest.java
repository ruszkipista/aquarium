package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import main.FishTank;

public class AppTest {
    @Test
    public void createFishTankWith240Lcapacity(){
        FishTank tank = new FishTank(240);
        assertEquals(240, tank.getVolumeInLiter());
    }
}
