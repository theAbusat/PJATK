public class Boat extends Vehicle {
    private String boatType; // e.g fishing, deck, walkaround etc..
    private String manufacturer;
    private String model;
    public Boat(double volume, String manufacturer, String model,String plateNumber) {
        super("Boat", volume, plateNumber);
        this.manufacturer = manufacturer;
        this.model = model;
    }


    @Override
    public String getPlateNumber() {
        return super.getPlateNumber();
    }
}
