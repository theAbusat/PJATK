public class Calculation {
    private int num1,num2;
    private String operation;

    public Calculation(int num1, String operation, int num2){
        this.num1 = num1;
        this.operation = operation;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public String getOperation() {
        return operation;
    }
}
