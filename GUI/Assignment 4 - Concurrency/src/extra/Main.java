package extra;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int SIZE = 10;
        final int NUMS = 13;

        int arr[] = new int[SIZE];
        int counter = 0;

        while(counter < SIZE){
            for (int i = 0; i < SIZE; i++){
                int number = (int)(Math.random()*(NUMS-1) + 1);
                if (contains(arr,number) == false){
                    arr[i] = number;
                }
            }
            counter++;
        }

        System.out.println("With SIZE = " + SIZE + "and NUMS=" + NUMS + " array has been\n" +
                "filled after " + counter + " trials");
        System.out.println("Array: " + Arrays.toString(arr));
    }

    public static boolean contains(int[] arr, int value){
        for (int element : arr) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }
}
