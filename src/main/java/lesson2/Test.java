package lesson2;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        try {
            arrayException();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void arrayException() {
        System.out.print("Input the array's size: ");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();

        String[][] array = new String[a][a];

        if (a != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("Input the array's element: ");
                Scanner elInput = new Scanner(System.in);
                String element = elInput.nextLine();
                array[i][j] = element;
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            String[] row = array[i];
            for (int j = 0; j < array[i].length; j++) {
                String value = row[j];

                try {
                    sum += Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println("The sum is " + sum);
    }
}
