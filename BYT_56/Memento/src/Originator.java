public class Originator {
    private String state;
    private History history = new History();

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        history.addMemento(createMemento());
        System.out.println("State set to \"" + state + "\"");
    }

    public Memento createMemento(){
        System.out.println("New Memento");
        return new Memento(state);
    }

    public void undo(){
        state = history.getMemento(history.index-1).getState();
        history.index--;
        System.out.println("State restored to \"" + state + "\"");
    }
}
