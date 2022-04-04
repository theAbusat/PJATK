import java.util.LinkedList;
import java.util.List;

public class Apartment extends Room {
    private static int serial = 1;
    private int apartmentID;
    private int availableRooms;
    private List<Person> persons;
    private boolean isRented;
    private boolean isRenewed;

    public Apartment(double volume, int availableRooms) {
        super(volume);
        this.apartmentID = serial++;
        this.persons = new LinkedList<Person>();
        this.availableRooms = availableRooms;
        this.isRented = false;
    }

    @Override
    public double getVolume() {
        return super.getVolume();
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRenewed(boolean renewed) {
        isRenewed = renewed;
    }

    public boolean isRenewed() {
        return isRenewed;
    }

    public int getApartmentID() {
        return apartmentID;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void addPerson(Person person){
        String fullName = person.getName() + person.getSurname();
        if (this.availableRooms > 0){
            persons.add(person);
            person.setTenant(true);
            availableRooms--;
            System.out.println(fullName + " added to the apartment " + apartmentID);
        } else
            System.out.println("There are no available rooms in apartment " + apartmentID);
    }
    public void personOut(Person person){
        String fullName = person.getName() + person.getSurname();
        if (persons.contains(person)){
            persons.remove(person);
            person.setTenant(false);
            availableRooms++;
            System.out.println(fullName + " is checked out of the apartment " + apartmentID);
        } else
            System.out.println("Person to check out not found.");
    }
    public Person findPerson(String pesel){
        for (int i = 0; i < persons.size(); i++){
            Person checkedPerson = persons.get(i);
            if (checkedPerson.getName().equals(pesel)){
                return checkedPerson;
            }
        }
        return null;
    }

    public String toString(){
        return "Apartment{ID number=" + apartmentID + ", volume=" + getVolume() + ", available rooms=" + availableRooms + "}";
    }
}
