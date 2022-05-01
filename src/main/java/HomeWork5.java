public class HomeWork5 {

    public static void main(String[] args) throws InterruptedException {
        firstMethod();
        secondMethod();
    }

    public static void firstMethod() {

        int SIZE = 10_000_000;

        float[] arr = new float[SIZE];

        long leadTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i ++) {
            arr[i] = 1;
        }

        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }

        System.out.println("First method " + (System.currentTimeMillis() - leadTime));
    }

    public static void secondMethod() throws InterruptedException {
        int SIZE = 10_000_000;
        int HALF = SIZE / 2;
        long leadTime = System.currentTimeMillis();

        float[] arrMain = new float[SIZE];

        float[] arrLeft = new float[SIZE/2];
        float[] arrRight = new float[SIZE/2];

        for(int i = 0; i < arrMain.length; i++) {
            arrMain[i] = 1;
        }

        System.arraycopy(arrMain, 0, arrLeft, 0, SIZE/2);
        System.arraycopy(arrMain, SIZE/2, arrRight, 0, SIZE/2);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrLeft.length; i++) {
                    arrLeft[i] = (float) (arrLeft[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                            Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrRight.length; i++) {
                    arrRight[i] = (float) (arrRight[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                            Math.cos(0.4f + i / 2));
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        float[] arrMerge = new float[SIZE];
        System.arraycopy(arrLeft, 0, arrMerge, 0, SIZE/2);
        System.arraycopy(arrRight, 0, arrMerge, SIZE/2, SIZE/2);

        System.out.println("Second method " + (System.currentTimeMillis() - leadTime));
    }
}
