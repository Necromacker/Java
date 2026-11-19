public class recursion {

    // correct way
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
        int i = 10;
        System.out.println(febo(i));
    }
}
