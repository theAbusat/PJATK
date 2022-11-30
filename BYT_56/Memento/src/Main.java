public class Main {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("start");
        originator.setState("update1");
        originator.setState("update2");
        originator.undo();
    }
}
