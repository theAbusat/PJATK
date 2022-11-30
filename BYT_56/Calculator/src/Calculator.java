import java.util.Scanner;

public class Calculator {
    static int result = 0;
    static Calculation calc = null;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            String input = sc.nextLine();
            String[] line = input.split(" ");
            int num1 = Integer.parseInt(line[0]);
            int num2 = Integer.parseInt(line[2]);
            String operation = line[1];

            Calculation calculation = new Calculation(num1,operation,num2);

            Chain add = new Addition(), sub = new Subtraction(), mul = new Multiply(), div = new Division();

            add.nextChain(sub);
            sub.nextChain(mul);
            mul.nextChain(div);

            add.calculate(calculation);
            System.out.println(result);
        } catch (NumberFormatException e){
            System.err.println(
                    "Cannot parse numbers. Enter in correct format");
        }
    }
}
