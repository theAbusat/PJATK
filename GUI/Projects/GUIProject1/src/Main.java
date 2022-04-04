import java.time.LocalDate;
import java.util.*;

public class Main {
    public static List<Apartment> apartments = new LinkedList<Apartment>();
    public static List<ParkingPlace> parkings = new LinkedList<ParkingPlace>();
    public static List<Person> people = new LinkedList<Person>();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws TooManyThingsException, InterruptedException {
        Apartment apartment1 = new Apartment(85,3);
        Apartment apartment2 = new Apartment(100, 4);
        Apartment apartment3 = new Apartment(115,5);
        Apartment apartment4 = new Apartment(90,3);
        Apartment apartment5 = new Apartment(55,2);
        ParkingPlace parking1 = new ParkingPlace(20);
        ParkingPlace parking2 = new ParkingPlace(22);
        ParkingPlace parking3 = new ParkingPlace(30);
        ParkingPlace parking4 = new ParkingPlace(14);
        ParkingPlace parking5 = new ParkingPlace(19);
        Person person1 = new Person("Abusat", "Aghali", "6578998", "Warsaw, Old Town");
        Person person2 = new Person("Dobromil", "Dabrowski", "3567893", "Warsaw, Koszykowa");
        Person person3 = new Person("Elon", "Musk", "3456789", "Warsaw, Centrum");
        Person person4 = new Person("Freddie", "Mercury", "8765000", "Krakow");
        Person person5 = new Person("Alina", "Symanski", "1209877", "Lodz, Piotrkowska");
        Person person6 = new Person("Cristiano", "Ronaldo", "1281390", "Lisbon,Portugal");

        apartments.add(apartment1);
        apartments.add(apartment2);
        apartments.add(apartment3);
        apartments.add(apartment4);
        apartments.add(apartment5);
        parkings.add(parking1);
        parkings.add(parking2);
        parkings.add(parking3);
        parkings.add(parking4);
        parkings.add(parking5);
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        people.add(person6);




        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit){
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0: printInstructions();
                break;
                case 1: printHouseState();
                break;
                case 2: rentApartment();
                break;
                case 3: rentParking();
                break;
                case 4: storeItem();
                break;
                case 5: removeItem();
                break;
                case 6: storeVehicle();
                break;
                case 7: removeVehicle();
                break;
                case 8: manageRents();
                break;
                case 9: quit = true;
                break;
            }
        }

    }
    public static void printInstructions(){
        System.out.println("\n Press: ");
        System.out.println("\t 0 - Show instructions.");
        System.out.println("\t 1 - Show available rentals.");
        System.out.println("\t 2 - Rent an apartment for a person.");
        System.out.println("\t 3 - Rent a parking place for a tenant.");
        System.out.println("\t 4 - Store an item into a room.");
        System.out.println("\t 5 - Remove an item from a room.");
        System.out.println("\t 6 - Store a vehicle to a parking place.");
        System.out.println("\t 7 - Remove a vehicle from a parking place.");
        System.out.println("\t 8 - Manage other tenants.");
        System.out.println("\t 8 - Quit application.");
    }
    public static void printHouseState(){
        System.out.println("\n Available estates: ");
        apartments.sort(Comparator.comparing(Apartment::getVolume));
        for(Apartment a : apartments){
            System.out.println(a);
        }
        System.out.println();
        parkings.sort(Comparator.comparing(ParkingPlace::getVolume));
        for (ParkingPlace p : parkings){
            System.out.println(p);
        }
        System.out.println();

    }
    public static void rentApartment(){
        int person;
        int choose;
        System.out.println("Which person wants start a rent? ");
        person = scanner.nextInt();
        Person tenant = people.get(person-1);
        String fullName = tenant.getName() + " " + tenant.getSurname();
        System.out.println("Which apartment " + fullName + " wants to rent?");
        choose = scanner.nextInt();
        Apartment toRent = apartments.get(choose-1);
        System.out.println("Enter a date which the contract will be until: ");
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print(" Month: ");
        int month = scanner.nextInt();
        System.out.print("Day: ");
        int day = scanner.nextInt();
        LocalDate endDate = LocalDate.of(year,month,day);
        tenant.rent(toRent, endDate);
    }
    public static void rentParking(){
        int person;
        int choose;
        System.out.println("Which person wants to start a rent? ");
        person = scanner.nextInt();
        Person tenant = people.get(person-1);
        String fullName = tenant.getName() + " " + tenant.getSurname();
        if(tenant.isTenant()){
            System.out.println("Which parking place " + fullName + " wants to rent?");
            choose = scanner.nextInt();
            ParkingPlace toRent = parkings.get(choose-1);
            System.out.println("Enter a date which the contract will be until: ");
            System.out.print("Year: ");
            int year = scanner.nextInt();
            System.out.print(" Month: ");
            int month = scanner.nextInt();
            System.out.print("Day: ");
            int day = scanner.nextInt();
            LocalDate endDate = LocalDate.of(year,month,day);
            tenant.rent(toRent, endDate);
        } else
            System.out.println("Only tenants can rent a parking place!");

    }
    public static void storeItem(){
        int person;
        int chooseParking;
        int chooseApartment;
        System.out.println("Which person wants to store an item? ");
        person = scanner.nextInt();
        Person tenant = people.get(person-1);
        String fullName = tenant.getName() + " " + tenant.getSurname();
        if(tenant.isTenant()){
            int choice;
            System.out.println("\nPress: ");
            System.out.println("\t 1 - Store item into a parking place");
            System.out.println("\t 2 - Store item into an apartment");
            choice = scanner.nextInt();
            switch (choice){
                case 1 :
                    System.out.println("Which parking place tenant wants to store an item? ");
                    chooseParking = scanner.nextInt();
                    ParkingPlace parkingPlace = parkings.get(chooseParking-1);
                    if(tenant.getRentals().contains(parkingPlace)){
                        System.out.print("Please enter the details of item - Name: ");
                        String name = scanner.nextLine();
                        scanner.nextLine();
                        System.out.print("Volume: ");
                        Double volume = scanner.nextDouble();
                        Item item = new Item(name, volume);
                        parkingPlace.insert(item);
                    }
                    else
                        System.out.println(fullName + " does not have an access to this parking place.");
                    break;
                case 2 :
                    System.out.println("Which apartment tenant wants to store an item? ");
                    chooseApartment = scanner.nextInt();
                    Apartment apartment = apartments.get(chooseApartment-1);
                    if(tenant.getRentals().contains(apartment)){
                        System.out.print("Please enter the details of item - Name: ");
                        String name = scanner.nextLine();
                        scanner.nextLine();
                        System.out.print("Volume: ");
                        Double volume = scanner.nextDouble();
                        Item item = new Item(name, volume);
                        apartment.insert(item);
                        break;
                    } else System.out.println(fullName + " does not have an access to this parking place.");
            }

        }
        else
            System.out.println(fullName + " is not a tenant.");
    }
    public static void removeItem(){
        int person;
        int chooseParking;
        int chooseApartment;
        System.out.println("Which person wants to remove an item? ");
        person = scanner.nextInt();
        Person tenant = people.get(person-1);
        String fullName = tenant.getName() + " " + tenant.getSurname();
        if (tenant.isTenant()){
            int choice;
            System.out.println("\nPress: ");
            System.out.println("\t 1 - Remove item from a parking place");
            System.out.println("\t 2 - Remove item from an apartment");
            choice = scanner.nextInt();
            switch (choice){
                case 1 :
                    System.out.println("From which parking place? ");
                    chooseParking = scanner.nextInt();
                    ParkingPlace parkingPlace = parkings.get(chooseParking-1);
                    if(tenant.getRentals().contains(parkingPlace)){
                        System.out.print("Please enter the name of item to remove: ");
                        String name = scanner.nextLine();
                        parkingPlace.takeOut(name);
                    }
                    else
                        System.out.println(fullName + " does not have an access to this parking place.");
                    break;
                case 2 :
                    System.out.println("From which apartment? ");
                    chooseApartment = scanner.nextInt();
                    Apartment apartment = apartments.get(chooseApartment-1);
                    if(tenant.getRentals().contains(apartment)){
                        System.out.print("Please enter the name of item to remove: ");
                        String name = scanner.nextLine();
                        apartment.takeOut(name);
                    }
                    else
                        System.out.println(fullName + " does not have an access to this parking place.");
                    break;
            }

        }
        else
            System.out.println(fullName + " is not a tenant.");
    }
    public static void storeVehicle(){
        int person;
        int choose;
        System.out.println("Which person wants to store a vehicle? ");
        person = scanner.nextInt();
        Person tenant = people.get(person-1);
        String fullName = tenant.getName() + " " + tenant.getSurname();
        if (tenant.isTenant()){
            System.out.println("Which parking place tenant wants to store a vehicle? ");
            choose = scanner.nextInt();
            ParkingPlace parkingPlace = parkings.get(choose-1);
            if(tenant.getRentals().contains(parkingPlace)){
                System.out.println("Please enter the details of the vehicle to store:  ");
                System.out.print("Volume - ");
                double volume = scanner.nextDouble();
                System.out.print("Plate number - ");
                String plateNumber = scanner.nextLine();
                System.out.print("Manufacturer - ");
                String manufacturer = scanner.nextLine();
                System.out.print("Model - ");
                String model = scanner.nextLine();
                System.out.print("TYPE of Vehicle(City car, Motorcycle etc..) - ");
                String type = scanner.nextLine();
                switch (type){
                    case "Amphibious" :
                        Amphibious amphibious = new Amphibious(volume,manufacturer,model, plateNumber);
                        parkingPlace.insert(amphibious);
                        break;
                    case "Boat" :
                        Boat boat = new Boat(volume,manufacturer,model,plateNumber);
                        parkingPlace.insert(boat);
                        break;
                    case "City car" :
                        CityCar cityCar = new CityCar(volume, manufacturer,model,plateNumber);
                        parkingPlace.insert(cityCar);
                        break;
                    case "Motorcycle" :
                        Motorcycle motorcycle = new Motorcycle(volume, manufacturer, model,plateNumber);
                        parkingPlace.insert(motorcycle);
                        break;
                    case "Off-Road" :
                        OffRoad offRoad = new OffRoad(volume, manufacturer, model,plateNumber);
                        parkingPlace.insert(offRoad);
                        break;
                }
            }
            else System.out.println(fullName + " does not have an acces to this parking place.");
        } else System.out.println(fullName + " is not tenant.");
    }
    public static void removeVehicle(){
        int person;
        int choose;
        System.out.println("Which person wants to remove a vehicle? ");
        person = scanner.nextInt();
        Person tenant = people.get(person-1);
        String fullName = tenant.getName() + " " + tenant.getSurname();
        if (tenant.isTenant()){
            System.out.println("From which parking place? ");
            choose = scanner.nextInt();
            ParkingPlace parkingPlace = parkings.get(choose-1);
            if(tenant.getRentals().contains(parkingPlace)){
                System.out.println("Please enter the vehicle plate number: ");
                String plateNumber = scanner.nextLine();
                parkingPlace.takeOutVehicle(plateNumber);
            } else System.out.println(fullName + " does not have an access to this parking place.");
        } else System.out.println(fullName + " is not tenant.");
    }
    public static void manageRents(){
        int choice;
        int person;
        System.out.println("Which person wants to manage the rents? ");
        person = scanner.nextInt();
        Person tenant = people.get(person-1);
        String fullName = tenant.getName() + " " + tenant.getSurname();
        if (tenant.isTenant()) {
            System.out.println("\nPress: ");
            System.out.println("\t 1 - Check in a person");
            System.out.println("\t 2 - Check out a person");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    int index;
                    String name,surname,pesel,address;
                    System.out.println("Please enter the personal details: ");
                    System.out.print("Name: ");
                    name = scanner.nextLine();
                    System.out.print("Surname: ");
                    surname = scanner.nextLine();
                    System.out.print("Pesel: ");
                    pesel = scanner.nextLine();
                    System.out.print("Address: ");
                    address = scanner.nextLine();
                    Person newTenant = new Person(name, surname, pesel, address);
                    System.out.println("Which apartment the new tenant checks in?");
                    index = scanner.nextInt();
                    Apartment apartment = apartments.get(index-1);
                    if (apartment.findPerson(pesel) != null){
                        System.out.println("This person is already in apartment " + apartment.getApartmentID());
                    } else {
                        tenant.checkInPerson(newTenant, apartment);
                    }
                    break;
                case 2 :
                    int indexNumber;
                    String peselNumber;
                    System.out.println("Please enter person's pesel number: ");
                    peselNumber = scanner.nextLine();
                    System.out.println("Which apartment this person checks out from? ");
                    indexNumber = scanner.nextInt();
                    Apartment apartment1 = apartments.get(indexNumber-1);
                    Person out = apartment1.findPerson(peselNumber);
                    if (out != null){
                        tenant.checkOutPerson(out,apartment1);
                    } else System.out.println("Person is not in apartment " + apartment1.getApartmentID());

            }
        } else System.out.println(fullName + " is not tenant.");
    }

}
