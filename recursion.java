public class recursion {

    public static boolean first_occurance(int key, int i) {

    public static boolean sorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return (sorted(arr, i + 1));
    }

    // correct way (time complexity - 2**n)
    public static int febo(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        int feb1 = febo(i - 1);
        int feb2 = febo(i - 2);
        int feb3 = feb1 + feb2;
        return feb3;
    }

    public static int sumofn(int i) {
        if (i == 1) {
            return (1);
        }
        return (i + sumofn(i - 1));

    }

    public static int factorial(int i) {
        if (i == 1) {
            return (1);
        }
        return (i * factorial(i - 1));

    }

    public static void increasing(int i) {
        if (i == 0) {
            System.out.println(i);
            return;
        }
        increasing(i - 1);
        System.out.println(i);
    }

    public static void decreasing(int i) {
        if (i >= 0) {
            System.out.println(i);
            decreasing(i - 1);
        }

    }

    public static void main(String[] args) {
        int i = 0;
        int arr[] = { 1, 2, 3, 4, 5 };
        System.out.println(sorted(5, 0));
    }
}
