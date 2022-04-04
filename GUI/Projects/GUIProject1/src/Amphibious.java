public class Amphibious extends Vehicle {
    private int waterProofHull;
    private String manufacturer;
    private String model;

    public Amphibious(double volume, String manufacturer, String model, String plateNumber) {
        super("Amphibious", volume, plateNumber);
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public void setWaterProofHull(int waterProofHull) {
        this.waterProofHull = waterProofHull;
    }

    @Override
    public String getPlateNumber() {
        return super.getPlateNumber();
    }
}
