import java.util.*;

public class TWDArray {

    // Spiral 2D Array
    public static void Spiral(int matrix[][]) {
        int start = 0;
        int end = matrix[0].length;
        while (start < end) {

            for (int i = start; i < end; i++) {
                if (i == start) {
                    for (int j = start; j < end; j++) {
                        // System.out.print(matrix[i][j] + " ");
                    }
                }
                System.out.print(i + " = i ");
                if (i == (end - 1)) {
                    for (int k = (end - 1); k >= 0; k--) {
                        System.out.print(k + " = k ");
                    }
                }
            }
            // System.out.print(start + " ");
            // System.out.print(end + " ");
            start++;
            end--;
        }
    }

    public static void main(String arg[]) {
        int x = 1;
        int matrix[][] = new int[3][4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = x;
                x++;
            }
        }
        Spiral(matrix);

    }
}
