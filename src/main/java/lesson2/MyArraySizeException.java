package lesson2;

public class MyArraySizeException extends IndexOutOfBoundsException {

    public MyArraySizeException() {
        super("It is the wrong size of array");
    }
}
