// Package.java
package TravelManagementSystem;

public class Package {
    private String destination;
    private String name;
    private String duration;
    private String booking;
    private String seasonalOffer;
    private String price;
    private String imagePath;
    private String benefit[] = new String[6];

    public Package(String destination,String name, String duration, String benefit1, String benefit2, String benefit3, 
                    String benefit4, String benefit5, String benefit6, String booking, String seasonalOffer, 
                    String price, String imagePath) {

        this.destination = destination;                
        this.name = name;
        this.duration = duration;
        this.benefit[0] = benefit1;
        this.benefit[1] = benefit2;
        this.benefit[2] = benefit3;
        this.benefit[3] = benefit4;
        this.benefit[4] = benefit5;
        this.benefit[5] = benefit6;
        this.booking = booking;
        this.seasonalOffer = seasonalOffer;
        this.price = price;
        this.imagePath = imagePath;
    }

    // Getters for all fields
    public String getDestination() { return destination; }
    public String getName() { return name; }
    public String getDuration() { return duration; }
    public String getbenefit1() { return benefit[0]; }
    public String getbenefit2() { return benefit[1]; }
    public String getbenefit3() { return benefit[2]; }
    public String getbenefit4() { return benefit[3]; }
    public String getbenefit5() { return benefit[4]; }
    public String getbenefit6() { return benefit[5]; }
    public String getBooking() { return booking; }
    public String getSeasonalOffer() { return seasonalOffer; }
    public String getPrice() { return price; }
    public String getImagePath() { return imagePath; }
}


