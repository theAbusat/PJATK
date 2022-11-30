public class BuilderTest {
    public static void main(String[] args) {
        Director director = new Director();
        ComputerBuilder computerBuilder = new ComputerBuilder();

        director.buildMacBook(computerBuilder);
        Computer macBook = computerBuilder.getResult();

        director.buildROGGamingLaptop(computerBuilder);
        Computer rog = computerBuilder.getResult();

        System.out.println(macBook);
        System.out.println(rog);
    }
}
