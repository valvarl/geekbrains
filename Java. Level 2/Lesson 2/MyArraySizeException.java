class MyArraySizeException extends IllegalArgumentException{

    MyArraySizeException() {
        super("Wrong size array passed.");
    }
}