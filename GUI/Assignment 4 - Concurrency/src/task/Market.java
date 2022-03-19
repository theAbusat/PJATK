package task;

import java.util.LinkedList;

public class Market {
    private static LinkedList<String> list = new LinkedList<>();
    private static int capacity = 5;

    public void produce() throws InterruptedException {
        String[] products = {"product 1","product 2","product 3","product 4","product 5"};
        int value = 0;

        while(true){
            synchronized (this){
                while(list.size() == capacity)
                    wait();

                System.out.println("Produced: " + products[value]);
                list.add(products[value++]);
                notify();

                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while(true){
            synchronized (this)
            {
                while(list.size() == 0)
                    wait();

                String product = list.removeFirst();

                System.out.println("Consumed: " + product);
                notify();

                Thread.sleep(1000);
            }
        }
    }
}
