class MyArrayDataException extends NumberFormatException {
    MyArrayDataException(int row, int col, String s) {
        super(String.format("For input string \"%s\" in %d row, %d column", s, row, col));
    }
}
