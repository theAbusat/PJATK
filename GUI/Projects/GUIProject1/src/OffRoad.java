public class OffRoad extends Vehicle {
    private String suspensionType;
    public int highProfileTires;
    private String manufacturer;
    private String model;

    public OffRoad(double volume, String manufacturer, String model, String plateNumber){
        super("Off-road", volume, plateNumber);
        this.manufacturer = manufacturer;
        this.model = model;
    }

    @Override
    public String getPlateNumber() {
        return super.getPlateNumber();
    }
}
