import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[][] array = ArrayInit(4, 4, new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"});
        try {
            System.out.println(MyArraySum(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Impossible to calculate the sum of array elements: " + e.getMessage());
        }
    }

    private static int MyArraySum(String[][] array) throws MyArraySizeException, MyArrayDataException{
        if (array.length != 4) throw new MyArraySizeException();
        int sum = 0;
        for (int i = 0; i < 4; i++){
            if (array[i].length != 4) throw new MyArraySizeException();
            for (int j = 0; j < 4; j++) {
                try{
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }
        return sum;
    }

    private static String[][] ArrayInit(int row, int col, String[] arg){
        Random random = new Random();
        String[][] array = new String[row][];
        for (int i = 0; i < row; i++) {
            array[i] = new String[col];
            for (int j = 0; j < col; j++) {
                array[i][j] = arg[random.nextInt(arg.length)];
            }
        }
        return array;
    }
}