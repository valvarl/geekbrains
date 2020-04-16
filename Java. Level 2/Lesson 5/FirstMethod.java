public class FirstMethod {
    private static final int size = 10_000_000;

    public static void FirstMethod(){
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) { arr[i] = 1;}

        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }
}
