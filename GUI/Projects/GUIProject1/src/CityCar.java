public class CityCar extends Vehicle {
    private String vehicleType; //e.g hatchback, sedan, coupe etc..
    private String manufacturer;
    private String model;


    public CityCar(double volume, String manufacturer, String model, String plateNumber) {
        super("City Car", volume, plateNumber);
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String getPlateNumber() {
        return super.getPlateNumber();
    }
}
