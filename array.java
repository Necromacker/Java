public class array {

    public static int find_key(int arr[], int key) {

        for (int i = 0; i <= arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String arg[]) {
        int arr[] = { 2, 3, 4, 5, 6 };
        int key = 4;
        System.out.println(find_key(arr, key));
    }
}
