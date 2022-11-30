import java.util.ArrayList;
import java.util.List;

public class History {
    private List<Memento> mementos = new ArrayList<>();
    int index = -1;

    public void addMemento(Memento m){
        mementos.add(m);
        index++;
    }

    public Memento getMemento(int i){
        return mementos.get(i);
    }

    public int getIndex() {
        return index;
    }
}
