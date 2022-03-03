package main;

public class Aquarium {
    public static void main(String[] args) throws Exception {
        FishTank tank = new FishTank(240, 11);
        tank.addWater(new Water(220));
        tank.addFish(new Clown("Nemo",    7, "orange", "white"));
        tank.addFish(new Tang("Dory",     5, "blue", true));
        tank.addFish(new Kong("Bubbles", 10, "yellow"));
        TreasureChest chest = new TreasureChest(TreasureChest.Status.OPEN);
        tank.addDecoration(chest);
        System.out.println("Status after filling the tank:\n"
                           +tank.getStatus());
        chest.closeLid();
        tank.feed();
        System.out.println("Status after feeding and closing the chest:\n"
                          +tank.getStatus());
        tank.removeFish();
        System.out.println("Status after removing big fish (at least 11g):\n"
                          +"There are " + tank.getNumberOfFish() + " fish in the tank\n"
                          +tank.getStatus());
    }
}
