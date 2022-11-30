public class ComputerBuilder implements Builder{
    private Brand brand;
    private String modelName;
    private Processor processor;
    private GraphicsCard graphicsCard;
    private boolean hasSSD;
    private int RAM_size;
    private double weight;

    @Override
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    @Override
    public void setGraphicsCard(GraphicsCard graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    @Override
    public void setHasSSD(boolean hasSSD) {
        this.hasSSD = hasSSD;
    }

    @Override
    public void setRAMSize(int RAM_size) {
        this.RAM_size = RAM_size;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Computer getResult(){
        return new Computer(brand, modelName, processor, graphicsCard, hasSSD, RAM_size, weight);
    }
}
