package task;

public class ProducerThread extends Thread {
    Market market = new Market();

    public ProducerThread(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        try {
            market.produce();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
