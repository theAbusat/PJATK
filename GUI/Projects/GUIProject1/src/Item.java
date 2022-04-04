public class Item {
    private String name;
    private double volume;

    public Item(String name, double volume) {
        this.name = name;
        this.volume = volume;
    }

    public String getName() {
        return this.name;
    }

    public double getVolume() {
        return this.volume;
    }
}
