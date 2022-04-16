package lesson2;

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(int row, int col) {
        super(String.format("The wrong type in array[%d][%d]", row, col));
    }

}
