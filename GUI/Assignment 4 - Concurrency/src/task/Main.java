package task;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Market market = new Market();

        ProducerThread producer1 = new ProducerThread(market);
        ProducerThread producer2 = new ProducerThread(market);
        ProducerThread producer3 = new ProducerThread(market);
        ProducerThread producer4 = new ProducerThread(market);
        ProducerThread producer5 = new ProducerThread(market);

        ConsumerThread consumer1 = new ConsumerThread(market);
        ConsumerThread consumer2 = new ConsumerThread(market);
        ConsumerThread consumer3 = new ConsumerThread(market);
        ConsumerThread consumer4 = new ConsumerThread(market);
        ConsumerThread consumer5 = new ConsumerThread(market);
        ConsumerThread consumer6 = new ConsumerThread(market);
        ConsumerThread consumer7 = new ConsumerThread(market);
        ConsumerThread consumer8 = new ConsumerThread(market);
        ConsumerThread consumer9 = new ConsumerThread(market);
        ConsumerThread consumer10 = new ConsumerThread(market);

        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        consumer5.start();
        consumer6.start();
        consumer7.start();
        consumer8.start();
        consumer9.start();
        consumer10.start();

    }

}
