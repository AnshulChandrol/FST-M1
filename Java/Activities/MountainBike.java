package activities;

public class MountainBike extends Bicycle{

    int seatHeight;
    public  MountainBike(int gears,int currentSpeed,int seatHight){
        super.currentSpeed=currentSpeed;
        super.gears=gears;
        this.seatHeight=seatHight;
    }
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
    public String bicycleDesc() {
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed +"\nSeat hight is "+seatHeight);
    }
}
