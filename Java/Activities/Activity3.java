package activities;

public class Activity3 {
    public static void main(String[]args){
        double seconds=1000000000;
        double EarthSeconds=31557600;
        double MercurySeconds=0.2408467;
        double VenusSeconds=0.61519726;
        double MarsSeconds=1.8808158;
        double JupiterSeconds=11.862615;
        double SaturnSeconds=29.447498;
        double UranusSeconds=84.016846;
        double NeptuneSeconds=164.79132;

        System.out.println("age in Earth :"+seconds/EarthSeconds);
        System.out.println("age in Mercury :"+seconds/EarthSeconds/MercurySeconds);
        System.out.println("age in Venus :"+seconds/EarthSeconds/VenusSeconds);
        System.out.println("age in Mars :"+seconds/EarthSeconds/MarsSeconds);
        System.out.println("age in Jupiter :"+seconds/EarthSeconds/JupiterSeconds);
        System.out.println("age in Saturn :"+seconds/EarthSeconds/SaturnSeconds);
        System.out.println("age in Uranus :"+seconds/EarthSeconds/UranusSeconds);
        System.out.println("age in Neptune :"+seconds/EarthSeconds/NeptuneSeconds);
    }
}
