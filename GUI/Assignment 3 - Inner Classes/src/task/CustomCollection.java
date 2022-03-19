package task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomCollection<TItem> {

    private List<TItem> elements = new ArrayList<>();

    public List<TItem> getElements() {
        return elements;
    }

    public void add(TItem item){
        if (!elements.contains(item)){
            elements.add(item);
        } else
            return;
    }

    public Iterator<TItem> iterator(){
        CustomIterator it = new CustomIterator(this);
        while(it.hasNext()){
            System.out.println(it.next());
        }
        return it;
    }

      class CustomIterator<TItem> implements Iterator<TItem> {

        private int index = 0;

         public CustomIterator(CustomCollection collection) {

         }

         @Override
         public boolean hasNext() {
            return index < elements.size() && elements.get(index) != null;
         }

         @Override
         public TItem next() {
             return (TItem) elements.get(index++);
         }
     }
}
