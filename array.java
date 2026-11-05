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
            for (int i = 0; i < arr.length; i++) {
                if (current < arr[i]) {
                    System.out.print("(" + current + "," + arr[i] + ")" + " ");
                }
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
        System.err.println("Total = " + (arr.length * (arr.length + 1)) / 2);
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

    // Calling the function to test
    public static void main(String arg[]) {
        int arr[] = { 2, 4, 6, 8, 10 };
        int key = 2;
        subarrayPS(arr);

    }
}
