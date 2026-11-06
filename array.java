public class array {

    // Optimized way to reverse array
    public static void reverse(int arr[]) {
        int first = 0;
        int last = arr.length - 1;
        while (first < last) {
            int temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;

            first++;
            last--;
        }
    }

    // Linear array search
    public static int Linear_search(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // Binary array search
    public static int Binary_search(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return -1;
    }

    // Pair in array
    public static void pair_array(int arr[]) {
        for (int j = 0; j < arr.length; j++) {
            int current = arr[j];
            for (int i = j + 1; i < arr.length; i++) {
                System.out.print("(" + current + "," + arr[i] + ")" + " ");
            }
            System.out.println();
        }
    }

    // Subarray & Maxsum (Brute Force , Time complexity = 0[N³])
    public static void subarrayBF(int arr[]) {
        int maxsum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                int end = j;
                System.out.print("( ");

                for (int k = i; k <= end; k++) {
                    System.out.print(arr[k] + " ");
                    sum = sum + arr[k];
                }
                System.out.print(") ");
                System.out.println("sum = " + sum);
                if (sum > maxsum) {
                    maxsum = sum;
                }
            }
            System.err.println();
        }
        System.out.println("maxsum = " + maxsum);
        System.out.println("Total = " + (arr.length * (arr.length + 1)) / 2);
    }

    // Subarray & Maxsum (Prefix Sum , Time complexity = 0[N²])
    public static void subarrayPS(int arr[]) {
        int maxsum = 0;
        int[] Prefixsum = new int[arr.length]; // Prefix sum array
        Prefixsum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            Prefixsum[i] = Prefixsum[i - 1] + arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int end = j;
                int sum = i == 0 ? Prefixsum[end] : Prefixsum[end] - Prefixsum[i - 1];
                if (sum > maxsum) {
                    maxsum = sum;
                }
            }
        }
        System.out.println("maxsum = " + maxsum);
        System.err.println("Total = " + (arr.length * (arr.length + 1)) / 2);
    }

    // Subarray & Maxsum (Kadane Algo , Time complexity = 0[N])
    public static void subarrayKA(int arr[]) {
        int currentsum = 0;
        int maxsum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentsum = currentsum + arr[i];
            if (currentsum < 0) {
                currentsum = 0;
            }
            maxsum = Math.max(currentsum, maxsum);
        }
        System.out.println("Maxsum = " + maxsum);
    }

    // Trapping Rainwater , Time Complexity = O(n²) , Space Complexity = O(n)
    public static void Rainwater(int arr[]) {

        int Total_water = 0;

        int[] Right_max = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < arr.length; j++) {
                if (max < arr[j]) {
                    max = arr[j];
                }
            }
            Right_max[i] = max;
        }

        int[] Left_max = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j >= 0; j--) {
                if (max < arr[j]) {
                    max = arr[j];
                }
            }
            Left_max[i] = max;
        }

        for (int i = 0; i < arr.length; i++) {
            int Water_level = Math.min(Right_max[i], Left_max[i]);
            Total_water = Total_water + Water_level - arr[i];
        }

        System.out.println(Total_water);
    }

    // Trapping Rainwater , Time Complexity = O(n) , Space Complexity = O(n)
    public static void RainwaterOP(int arr[]) {
        int n = arr.length;
        if (n == 0)
            return;

        // 1. Calculate Left Max array in a single O(n) pass
        int[] Left_max = new int[n];
        Left_max[0] = arr[0];
        for (int i = 1; i < n; i++) {
            Left_max[i] = Math.max(arr[i], Left_max[i - 1]);
        }

        // 2. Calculate Right Max array in a single O(n) pass
        int[] Right_max = new int[n];
        Right_max[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            Right_max[i] = Math.max(arr[i], Right_max[i + 1]);
        }

        // 3. Calculate trapped water
        int Total_water = 0;
        for (int i = 0; i < n; i++) {
            int Water_level = Math.min(Left_max[i], Right_max[i]);
            Total_water += Water_level - arr[i];
        }

        System.out.println(Total_water);
    }

    // Calling the function to test
    public static void main(String arg[]) {
        int arr[] = { 2, 0, 2 };
        int key = 2;
        Rainwater(arr);

    }
}
