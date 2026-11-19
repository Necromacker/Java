public class recursion {

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
        int i = 5;
        System.out.println(sumofn(i));
    }
}
