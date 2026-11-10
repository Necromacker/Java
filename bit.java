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

    // Clear Bit Range
    public static void ClearBitRange(int num, int start, int end) {
        int left = (~0) << (end + 1);
        int right = ~((~0) << start);
        int rangemask = left | right;
        System.out.println(num & rangemask);
    }

    public static void main(String[] args) {
        ClearBitRange(10, 2, 4);
    }
}