public class recursion {

    public static void decreasing(int i) {
        if (i >= 0) {
            System.out.println(i);
            decreasing(i - 1);
        }

    }

    public static void main(String[] args) {
        int i = 10;
        decreasing(i);
    }
}
