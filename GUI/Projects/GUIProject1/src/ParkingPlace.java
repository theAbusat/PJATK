import java.util.LinkedList;
import java.util.List;

public class ParkingPlace extends Room {
    private static int serial = 1;
    private int parkingID;
    private List<Item> storedItems;
    private List<Vehicle> storedVehicles;
    private boolean isRented;

    public ParkingPlace(double volume) {
        super(volume);
        this.parkingID = serial++;
        this.storedItems = new LinkedList<>();
        this.storedVehicles = new LinkedList<Vehicle>();
        this.isRented = false;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public boolean isRented() {
        return isRented;
    }

    public int getParkingID() {
        return parkingID;
    }

    @Override
    public double getVolume() {
        return super.getVolume();
    }

    public void insert(Item item) {
        String itemName = item.getName();
        double parkingVolume = super.getVolume();
        if(findItem(itemName) == null){
            if (item.getVolume() <= parkingVolume ){
                super.setVolume(parkingVolume - item.getVolume()) ;
                this.storedItems.add(item);
                System.out.println(itemName + " stored to the parking place number " + parkingID);
            } else {
                try {
                    throw new TooManyThingsException("Remove some old items to insert a new item.");
                } catch (TooManyThingsException e) {
                    e.printStackTrace();
                }
            }
        } else
            System.out.println("This " + itemName + " is already in this parking place.");
    }
    public void insert(Vehicle vehicle) {
        String plate = vehicle.getPlateNumber();
        double parkingVolume = super.getVolume();
            if (vehicle.getVolume() <= parkingVolume){
                super.setVolume(parkingVolume - vehicle.getVolume());
                this.storedVehicles.add(vehicle);
                System.out.println("Vehicle with plate number " + plate + " stored to the parking place number " + parkingID);
            }
            else{
                try {
                    throw new TooManyThingsException("Remove some old items to insert a new item.");
                } catch (TooManyThingsException e) {
                    e.printStackTrace();
                }
            }

    }


    public void takeOut(String itemName) {
        if (this.storedItems != null){
            Item takeOut = findItem(itemName);
            if (takeOut == null){
                System.out.println("Cannot find your item in the parking place " + parkingID);
            } else{
                storedItems.remove(takeOut);
                System.out.println(itemName + " removed from the parking place " + parkingID);
            }

        } else
            System.out.println("There are no items stored.");
    }
    public void takeOutVehicle(String plateNumber){
        if (this.storedVehicles != null){
            Vehicle takeOut = findVehicle(plateNumber);
            if (takeOut == null){
                System.out.println("Cannot find the vehicle in the parking place " + parkingID);
            } else {
                storedVehicles.remove(takeOut);
                System.out.println(takeOut.getName() + "with plate number " + takeOut.getPlateNumber() + " removed from the parking place " + parkingID);
            }
        }
    }
    public Item findItem(String itemName){
        for (int i = 0; i < storedItems.size(); i++){
            Item checkedItem = storedItems.get(i);
            if (checkedItem.getName().equals(itemName)){
                return checkedItem;
            }
        }
        return null;
    }
    public Vehicle findVehicle(String plateNumber){
        for(int i = 0; i < storedVehicles.size(); i++){
            Vehicle checkedVehicle = storedVehicles.get(i);
            if (checkedVehicle.getPlateNumber().equals(plateNumber)){
                return checkedVehicle;
            }
        }
        return null;
    }
    public String toString(){
        return "Parking Place={ID number=" + parkingID + ", volume=" + getVolume() + "}";
    }
}
