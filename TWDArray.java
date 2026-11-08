import java.util.*;

public class TWDArray {

    // Spiral 2D Array
    public static void Spiral(int matrix[][]) {
        int start = 0;
        int end = matrix[0].length;

        for (int i = start; i < end; i++) {
            for (int j = start; j < end; j++) {
                if (i == start) {
                    System.out.print(matrix[start][j] + " ");
                }
                if (j == end - 1) {
                    if (i == start) {
                        System.out.print("");
                    } else {
                        System.out.print(matrix[i][end - 1] + " ");
                    }
                }
            }
        }
        // for (int i = end - 1; i >= start; i--) {
        // for (int j = end - 1; j >= start; j--) {
        // if (i == end - 1) {
        // if (j == end - 1) {
        // System.out.print("");
        // } else {
        // System.out.print(matrix[end - 1][j] + " ");
        // }
        // }
        // if (j == start) {
        // if (i == end - 1) {
        // System.out.print("");
        // } else {
        // System.out.print(matrix[i][start] + " ");
        // }

        // }
        // }
        // }
        System.out.print(start + " ");
        System.out.print(end + " ");
        start++;
        end--;
    }

    public static void main(String arg[]) {
        int x = 1;
        int matrix[][] = new int[4][4];
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
