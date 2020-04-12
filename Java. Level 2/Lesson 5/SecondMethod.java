import java.util.Arrays;

public class SecondMethod {
    private static final int size = 10_000_000;
    private static final int h = size / 2;

    public static void SecondMethod() {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) { arr[i] = 1;}

        long a = System.currentTimeMillis();

        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread threadA = new Thread(() -> { new Task(a1); });
        Thread threadB = new Thread(() -> { new Task(a2); });

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println(System.currentTimeMillis() - a);
    }
}

class Task implements Runnable {
    private float[] arr;

    Task(float[] arr){
        this.arr = arr;
        run();
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
