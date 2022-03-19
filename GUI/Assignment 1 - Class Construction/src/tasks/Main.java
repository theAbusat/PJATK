package tasks;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Producer mercedes = new Producer("Mercedes");
        Producer man = new Producer("MAN");
        Bus bus1 = new Bus(mercedes, LocalDate.of(2012,3,30),
                150000,false, new BigDecimal(200.0), Fuel.GAS);

        Tram tram1 = new Tram(mercedes, LocalDate.of(2017,10,10),50000,true);

        Bus bus2 = new Bus(man, LocalDate.of(2020,1,15),
                30000,true,new BigDecimal(300.5),Fuel.DIESEL);

        System.out.println(bus2);
        System.out.println(tram1);
        System.out.println(bus1);



    }
}
