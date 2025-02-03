package TaxiBookingSystem;

public class Taxi implements Cloneable{

    private int customerId;
    private char currentLocation = 'A';
    private char dropLocation;
    private int earnings;
    private char pickupLocation;
    private int pickUpTime;
    private int dropTime;
    private int taxiId;

    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    public void setPickupLocation(char pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public void setPickUpTime(int pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public void setDropTime(int dropTime) {
        this.dropTime = dropTime;
    }

    public void setCurrentLocation(char currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setDropLocation(char dropLocation) {
        this.dropLocation = dropLocation;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }

    public int getCustomerId() {
        return customerId;
    }

    public char getPickupLocation() {
        return pickupLocation;
    }

    public int getPickUpTime() {
        return pickUpTime;
    }

    public int getDropTime() {
        return dropTime;
    }

    public int getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }

    public void setCustomerId(int id) {
        this.customerId = id;
    }

    public char getCurrentLocation() {
        return currentLocation;
    }

    public char getDropLocation() {
        return dropLocation;
    }

    public int getEarnings() {
        return earnings;
    }
}
