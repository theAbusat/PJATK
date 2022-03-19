package tasks;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Bus extends Vehicle {

    private BigDecimal engineCapacity;
    private Fuel fuelType;

    public Bus(Producer producer, LocalDate dateOfManufacture, double mileage, boolean lowFloor, BigDecimal engineCapacity, Fuel fuelType) {
        super(producer, dateOfManufacture, mileage, lowFloor);
        this.engineCapacity = engineCapacity;
        this.fuelType = fuelType;
    }

    public BigDecimal getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(BigDecimal engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Fuel getFuelType() {
        return fuelType;
    }

    public void setFuelType(Fuel fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Bus[Producer: " + getProducer() + ", Date of Manufacture: " + getDateOfManufacture() + ", Mileage: " +
                getMileage() + ", Low-Floor: " + isLowFloor() + ", Age: " + this.getVehicleAge() + ", Engine Capacity: " +
                engineCapacity + ", Fuel Type: " + fuelType + "]";
    }
}
