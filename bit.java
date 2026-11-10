import java.util.*;

public class bit {

    // Odd & Even Bitwise
    public static void bitodd(int num) {
        if ((num & 1) == 1) {
            System.out.println("Odd");
        } else {
            System.out.println("Even");
        }
    }

    //
    public static void GetBit(int num, int i) {
        int bit = num >> i;
        if ((bit & 1) == 1) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    public static void main(String[] args) {
        int num = 7;
        int i = 1;
        GetBit(num, i);
    }
}