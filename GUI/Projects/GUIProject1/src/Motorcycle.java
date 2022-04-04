public class Motorcycle extends Vehicle {
    private String manufacturer;
    private String model;
    private int helmet;
    public Motorcycle(double volume,String manufacturer, String model, String plateNumber) {
        super("Motorcycle", volume, plateNumber);
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public int getHelmet() {
        return helmet;
    }

    @Override
    public String getPlateNumber() {
        return super.getPlateNumber();
    }
}
