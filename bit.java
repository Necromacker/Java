import java.util.*;

public class bit {

    public static void bitodd(int num) {
        if ((num & 1) == 1) {
            System.out.println("Odd");
        } else {
            System.out.println("Even");
        }
    }

    public static void main(String[] args) {
        int num = 1;
        bitodd(num);
    }
}