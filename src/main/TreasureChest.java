package main;

public class TreasureChest implements Tankable {
    public static enum Status {OPEN, CLOSED};
    private Status lidStatus;

    public TreasureChest(Status status){
        this.lidStatus = status;
    }

    public boolean isClosed(){
        return this.lidStatus==Status.CLOSED;
    }

    public void closeLid(){
        this.lidStatus = Status.CLOSED;
    }
    public void openLid(){
        this.lidStatus = Status.OPEN;
    }

    public String status(){
        return "Treasure Chest"
             + " - its lid is " + (isClosed()?"closed":"open");
    }
}
