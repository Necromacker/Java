public class array {

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

    public static int Linear_search(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

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

    public static void main(String arg[]) {
        int arr[] = { 2, 4, 6, 8, 10 };
        int key = 2;
        pair_array(arr);

    }
}
