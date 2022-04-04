public abstract class Vehicle  {
    private String name;
    private double volume;
    private String plateNumber;

    public Vehicle(String name, double volume, String plateNumber) {
        this.name = name;
        this.volume = volume;
        this.plateNumber = plateNumber;
    }


    public String getName() {
        return name;
    }


    public double getVolume() {
        return volume;
    }

    public String getPlateNumber() {
        return plateNumber;
    }
}

