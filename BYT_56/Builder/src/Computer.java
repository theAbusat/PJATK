public class Computer {
    private final Brand brand;
    private final String modelName;
    private Processor processor;
    private GraphicsCard graphicsCard;
    private boolean hasSSD;
    private int RAM_size;
    private double weight;
    boolean isPowerOn = false;

    public Computer(Brand brand, String modelName, Processor processor, GraphicsCard graphicsCard, boolean hasSSD, int RAM_size, double weight) {
        this.brand = brand;
        this.modelName = modelName;
        this.processor = processor;
        this.graphicsCard = graphicsCard;
        this.hasSSD = hasSSD;
        this.RAM_size = RAM_size;
        this.weight = weight;
    }

    public void powerOn(){
        isPowerOn = true;
        System.out.println(this.brand + " " + this.modelName + " turned on.");
    }

    public void powerOff(){
        isPowerOn = false;
        System.out.println(this.brand + " " + this.modelName + " turned off.");
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand=" + brand +
                ", modelName='" + modelName + '\'' +
                ", processor=" + processor +
                ", graphicsCard=" + graphicsCard +
                ", hasSSD=" + hasSSD +
                ", RAM_size=" + RAM_size +
                ", weight=" + weight +
                '}';
    }
}
