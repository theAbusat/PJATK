public class Director {
    public void buildROGGamingLaptop(Builder builder){
        builder.setBrand(Brand.ACER);
        builder.setModelName("ROG Strix");
        builder.setProcessor(Processor.Intel);
        builder.setGraphicsCard(new GraphicsCard(Processor.AMD, "Ryzen 7"));
        builder.setHasSSD(true);
        builder.setRAMSize(16);
        builder.setWeight(2.1);
    }

    public void buildMacBook(Builder builder){
        builder.setBrand(Brand.APPLE);
        builder.setModelName("Macbook Air");
        builder.setProcessor(Processor.APPLE);
        builder.setGraphicsCard(new GraphicsCard(Processor.APPLE, "M1"));
        builder.setHasSSD(true);
        builder.setRAMSize(16);
        builder.setWeight(1.5);
    }
}
