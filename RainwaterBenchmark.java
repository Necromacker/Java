import java.util.Random;

public class RainwaterBenchmark {

    public static void main(String[] args) {
        int size = 100000; // 100,000 elements
        int[] arr = generateTestCase(size);

        System.out.println("--- BENCHMARK RESULTS (Array Size: " + size + ") ---\n");

        // 1. Original O(n²)
        runAndMeasure("1. Original O(n²)", () -> rainwaterOriginalON2(arr));

        // 2. DP O(n) Time, O(n) Space
        runAndMeasure("2. DP Approach O(n)", () -> rainwaterDPON(arr));

        // 3. Two-Pointer O(n) Time, O(1) Space
        runAndMeasure("3. Two-Pointer O(1) Space", () -> rainwaterTwoPointer(arr));
    }

    // Helper method to measure time and memory
    public static void runAndMeasure(String label, Runnable task) {
        System.gc(); // Suggest garbage collection for fair memory measurement
        long memBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();

        long memAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long memoryUsedKB = Math.max(0, (memAfter - memBefore) / 1024);
        double timeMs = (endTime - startTime) / 1_000_000.0;

        System.out.println(label);
        System.out.println("   Time Taken  : " + String.format("%.3f", timeMs) + " ms");
        System.out.println("   Memory Used : ~" + memoryUsedKB + " KB\n");
    }

    // Test case generator
    public static int[] generateTestCase(int size) {
        Random rand = new Random(42);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(500);
        }
        return arr;
    }

    // --- IMPLEMENTATIONS ---

    public static int rainwaterOriginalON2(int[] arr) {
        int Total_water = 0;
        int[] Right_max = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < arr.length; j++) {
                if (max < arr[j])
                    max = arr[j];
            }
            Right_max[i] = max;
        }
        int[] Left_max = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j >= 0; j--) {
                if (max < arr[j])
                    max = arr[j];
            }
            Left_max[i] = max;
        }
        for (int i = 0; i < arr.length; i++) {
            int Water_level = Math.min(Right_max[i], Left_max[i]);
            Total_water = Total_water + Water_level - arr[i];
        }
        return Total_water;
    }

    public static int rainwaterDPON(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;
        int[] Left_max = new int[n];
        Left_max[0] = arr[0];
        for (int i = 1; i < n; i++)
            Left_max[i] = Math.max(arr[i], Left_max[i - 1]);

        int[] Right_max = new int[n];
        Right_max[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            Right_max[i] = Math.max(arr[i], Right_max[i + 1]);

        int Total_water = 0;
        for (int i = 0; i < n; i++) {
            Total_water += Math.min(Left_max[i], Right_max[i]) - arr[i];
        }
        return Total_water;
    }

    public static int rainwaterTwoPointer(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;
        int left = 0, right = n - 1;
        int left_max = 0, right_max = 0;
        int Total_water = 0;

        while (left < right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= left_max)
                    left_max = arr[left];
                else
                    Total_water += left_max - arr[left];
                left++;
            } else {
                if (arr[right] >= right_max)
                    right_max = arr[right];
                else
                    Total_water += right_max - arr[right];
                right--;
            }
        }
        return Total_water;
    }
}