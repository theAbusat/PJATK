import java.security.spec.RSAOtherPrimeInfo;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Person {
    private String name;
    private String surname;
    private String pesel;
    private String address;
    private boolean isTenant = false;
    private List<Room> rentals;
    private List<TenantLetter> receivedLetters;

    public Person(String name, String surname, String pesel, String address) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.address = address;
        this.rentals = new LinkedList<Room>();
        this.receivedLetters = new LinkedList<TenantLetter>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPesel() {
        return pesel;
    }

    public String getAddress() {
        return address;
    }

    public List<Room> getRentals() {
        return rentals;
    }

    public boolean isTenant() {
        return isTenant;
    }

    public void setTenant(boolean tenant) {
        isTenant = tenant;
    }

    public void rent(Apartment apartment, LocalDate endDate){
        String fullName = this.getName() + " " + this.getSurname();
        if (receivedLetters.size() >= 3){
            try {
                throw new ProblematicTenantException("Person " + fullName + " had already renting rooms: " + getRentals());
            } catch (ProblematicTenantException e) {
                e.printStackTrace();
            }
        } else {
            if (! apartment.isRented()){
                if (rentals.size() < 5){
                    System.out.println("Tenant " + fullName + " successfully rented the apartment " + apartment.getApartmentID() +
                            " from " + LocalDate.now() + " to " + endDate + ".");
                    rentals.add(apartment);
                    apartment.setRented(true);
                    setTenant(true);
                    apartment.setAvailableRooms(apartment.getAvailableRooms()-1);
                    apartment.getPersons().add(this);
                    Thread thread = new Thread(() -> {
                        LocalDate startDate = LocalDate.now();
                        while (startDate.isBefore(endDate)){
                            try {
                                Thread.sleep(5000);
                                startDate = startDate.plusDays(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (startDate.equals(endDate)){
                            receiveTenantLetter("Rental for apartment " + apartment.getApartmentID() + " has expired.\n Note:" +
                                    " Tenant must renew the contract within 30 days to be able to stay in the apartment.",apartment);
                            apartment.setRented(false);
                        }
                    });
                    thread.start();
                } else
                    System.out.println("Total number of rentals cannot be more than 5.");
            } else
                System.out.println("This apartment is already rented.");
        }
    }
    public void rent(ParkingPlace parkingPlace, LocalDate endDate){
        String fullName = getName() + getSurname();
            if (!parkingPlace.isRented()){
                if (rentals.size() < 5){
                    rentals.add(parkingPlace);
                    parkingPlace.setRented(true);
                    System.out.println("Tenant " + fullName + " successfully rented the parking place " + parkingPlace.getParkingID() +
                            " from "  + LocalDate.now() + " to " + endDate + ".");
                    Thread thread = new Thread(() -> {
                        LocalDate startDate = LocalDate.now();
                        while (startDate.isBefore(endDate)){
                            try {
                                Thread.sleep(5000);
                                startDate = startDate.plusDays(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (startDate.equals(endDate)){
                            receiveTenantLetter("Rental for parking " + parkingPlace.getParkingID() + " has expired.\nNote:Tenant " +
                                    "must renew the contract within 30 days to be able to use this parking.", parkingPlace);
                            parkingPlace.setRented(false);
                        }
                    });
                    thread.start();
                }
                else
                    System.out.println("Total number of rentals cannot be more than 5.");
            } else
                System.out.println("This parking place is already rented");
    }
    public void checkInPerson(Person personToAdd, Apartment apartment){
        if (apartment.getPersons().get(0).getName().equals(this.name)){
            int personRents = personToAdd.getRentals().size();
            if (personRents < 5){
                apartment.addPerson(personToAdd);
            }
        } else
            System.out.println("This person is not responsible for checking in other persons.");
    }
    public void checkOutPerson(Person person, Apartment apartment){
        if (this.name.equals(apartment.getPersons().get(0).getName())){
            apartment.personOut(person);
        } else
            System.out.println("This person is not responsible for checking out other persons.");
    }

    private void receiveTenantLetter(String message, Room expiredRoom){
        TenantLetter tenantLetter = new TenantLetter();
        if (this.receivedLetters.size() <= 3){
            this.receivedLetters.add(tenantLetter);
            tenantLetter.setExpired(expiredRoom);
            System.out.println(message);

        }


    }
    public void printRentalDetails(){
        System.out.print("Rentals");
        for (int i = 0; i < rentals.size(); i++){
            System.out.println(rentals.get(i));
        }
    }
    public void renewApartment(TenantLetter tenantLetter){
        Apartment renew = (Apartment) tenantLetter.getExpired();
        renew.setRenewed(true);
    }

}
