package tasks;

import java.time.LocalDate;

public class Tram extends Vehicle {

    public Tram(Producer producer, LocalDate dateOfManufacture, double mileage, boolean lowFloor) {
        super(producer, dateOfManufacture, mileage, lowFloor);
    }

    @Override
    public String toString() {
        System.out.print("Tram");
        return super.toString();
    }
}
