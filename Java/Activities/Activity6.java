package activities;

public class Activity6 {
    public static void main(String[]args) throws InterruptedException {
        Plane plane=new Plane();
        plane.Plane(10);
        plane.onBoard("Ram");
        plane.onBoard("sita");
        plane.onBoard("lakshman");
        plane.onBoard("arjun");
        plane.onBoard("jhon");
        plane.onBoard("riya");
        plane.onBoard("priya");
        plane.onBoard("rahul");
        System.out.println(plane.takeOff());
        System.out.println(plane.getPassengers());
        Thread.sleep(5000);
        plane.land();
        System.out.println(plane.getLastTimeLanded());
    }
}
