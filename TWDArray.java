import java.util.*;

public class TWDArray {

    // Spiral 2D Array
    public static void Spiral(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
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
