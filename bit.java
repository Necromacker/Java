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

    // Get nth Bit
    public static void GetBit(int num, int i) {
        int bit = num >> i;
        if ((bit & 1) == 1) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    // Update Bit
    public static void UpdateBit(int num, int i, int newbit) {
        int bit = num & ~(1 << i);
        System.out.println(bit | (newbit << i));
    }

    public static void main(String[] args) {
        int num = 10;
        int i = 2;
        UpdateBit(num, i, 1);
    }
}