package test;

import org.junit.jupiter.api.Test;
import tasks.Bus;
import tasks.Fuel;
import tasks.Producer;
import tasks.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void getDateOfManufacture() {
        Producer producer = new Producer("Mercedes");
        Vehicle vehicle = new Bus(producer, LocalDate.of(2019,3,4),6000,
                true,new BigDecimal(200.0), Fuel.DIESEL);
        assertEquals(vehicle.getDateOfManufacture(),LocalDate.of(2019,3,4));
    }


    @Test
    void isLowFloor() {
        Producer producer = new Producer("Mercedes");
        Vehicle vehicle = new Bus(producer, LocalDate.of(2019,3,4),6000,
                true,new BigDecimal(200.0), Fuel.DIESEL);
        assertEquals(vehicle.isLowFloor(),true);
    }

    @Test
    void getVehicleAge() {
        Producer producer = new Producer("Mercedes");
        Vehicle vehicle = new Bus(producer, LocalDate.of(2019,3,4),6000,
                true,new BigDecimal(200.0), Fuel.DIESEL);
        assertEquals(vehicle.getVehicleAge(), 2);
    }
}