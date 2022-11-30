public interface Builder {
    void setBrand(Brand brand);
    void setModelName(String modelName);
    void setProcessor(Processor processor);
    void setGraphicsCard(GraphicsCard graphicsCard);
    void setHasSSD(boolean hasSSD);
    void setRAMSize(int RAM_size);
    void setWeight(double weight);
}

enum Brand {
    ASUS, ACER, APPLE, LENOVO, HP, DELL
}

enum Processor {
    Intel, AMD, APPLE
}

class GraphicsCard {
    private final Processor processor;
    private final String name;

    public GraphicsCard(Processor processor, String name) {
        this.processor = processor;
        this.name = name;
    }

    public Processor getProcessor() {
        return processor;
    }

    public String getName() {
        return name;
    }
}


