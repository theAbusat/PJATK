import java.util.LinkedList;
import java.util.List;

public class Room {
    private double volume;
    private List<Item> storedItems;

    public Room(double volume){
        this.volume = volume;
        this.storedItems = new LinkedList<Item>();
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void insert(Item item) {
        String name = item.getName();
        if(findItem(name) == null){
            if (item.getVolume() <= this.volume){
                this.volume -= item.getVolume();
                this.storedItems.add(item);
                System.out.println(name + " stored to the room");
            } else {
                try {
                    throw new TooManyThingsException("Remove some old items to insert a new item");
                } catch (TooManyThingsException e) {
                    e.printStackTrace();
                }
            }
        } else
            System.out.println("This " + name + " is already in the room");

    }
    public void takeOut(String itemName){
        if (this.storedItems != null){
            Item takeOut = findItem(itemName);
            if (takeOut == null){
                System.out.println("Cannot find your item in this room.");
            }
            storedItems.remove(takeOut);
            System.out.println(itemName + " removed from the room.");
        } else
            System.out.println("There are no items stored.");
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
}
