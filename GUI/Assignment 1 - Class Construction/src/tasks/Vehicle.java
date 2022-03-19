package tasks;

import java.time.LocalDate;
import java.time.Period;

public abstract class Vehicle {
    private Producer producer;
    private LocalDate dateOfManufacture;
    private double mileage;
    private boolean lowFloor;
    private boolean articulated;
    private int vehicleAge;

    public Vehicle(Producer producer, LocalDate dateOfManufacture, double mileage, boolean lowFloor) {
        this.producer = producer;
        this.dateOfManufacture = dateOfManufacture;
        this.mileage = mileage;
        this.lowFloor = lowFloor;
        if (isLowFloor()){
            this.articulated = false;
        } else
            this.articulated = true;

        this.vehicleAge = this.getVehicleAge();
    }

    public Producer getProducer() {
        return producer;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public double getMileage() {
        return mileage;
    }

    public boolean isLowFloor() {
        return lowFloor;
    }

    public boolean isArticulated() {
        return articulated;
    }

    public int getVehicleAge() {
        vehicleAge = Period.between(dateOfManufacture,LocalDate.now()).getYears();
        return vehicleAge;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setLowFloor(boolean lowFloor){
        this.lowFloor = lowFloor;
    }


    public String toString(){
        return "[Producer: " + producer + ", Date of Manufacture: " + dateOfManufacture + ", Mileage: " +
                mileage + ", Low-Floor: " + lowFloor + ", Age: " + this.getVehicleAge() + "]";
    }
}
