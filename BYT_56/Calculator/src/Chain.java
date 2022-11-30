public interface Chain {
    void nextChain(Chain nextChain);
    void calculate(Calculation calculation);
}
