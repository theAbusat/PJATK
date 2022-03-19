package task;

public class ConsumerThread extends Thread {
    Market market = new Market();

    public ConsumerThread(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        try {
            market.consume();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
