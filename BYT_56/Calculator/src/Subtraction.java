public class Subtraction implements Chain{
    private Chain next;

    @Override
    public void nextChain(Chain nextChain) {
        next = nextChain;
    }

    @Override
    public void calculate(Calculation calculation) {
        if(calculation.getOperation().equals("-")){
            Calculator.result = calculation.getNum1()-calculation.getNum2();
        } else next.calculate(calculation);
    }
}
