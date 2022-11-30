public class Addition implements Chain{
    private Chain next;

    @Override
    public void nextChain(Chain nextChain) {
        next = nextChain;
    }

    public void calculate(Calculation calculation){
        if (calculation.getOperation().equals("+")){
            Calculator.result = calculation.getNum1() + calculation.getNum2();
        } else next.calculate(calculation);
    }

}
