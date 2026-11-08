import java.util.*;

public class TWDArray {

    // Spiral 2D Array
    public static void Spiral(int matrix[][]) {
        int start = 0;
        int end = matrix[0].length;
        while (start < end) {
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
            for (int i = end - 1; i >= start; i--) {
                for (int j = end - 1; j >= start; j--) {
                    if (i == end - 1) {
                        if (j == end - 1) {
                            System.out.print("");
                        } else {
                            System.out.print(matrix[end - 1][j] + " ");
                        }
                    }
                    if (j == start) {
                        if (i == end - 1) {
                            System.out.print("");
                        } else {
                            if (i == start) {
                                System.out.print("");
                            } else {
                                System.out.print(matrix[i][start] + " ");
                            }
                        }

                    }
                }
            }
            start++;
            end--;
        }
    }

    // Spiral 2D Array Optimized
    public static void OPSpiral(int matrix[][]) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // 1. Traverse Right along the top row
            for (int j = colStart; j <= colEnd; j++) {
                System.out.print(matrix[rowStart][j] + " ");
            }
            rowStart++;

            // 2. Traverse Down along the rightmost column
            for (int i = rowStart; i <= rowEnd; i++) {
                System.out.print(matrix[i][colEnd] + " ");
            }
            colEnd--;

            // 3. Traverse Left along the bottom row with 'if' inside the loop
            for (int j = colEnd; j >= colStart; j--) {
                if (rowStart == rowEnd) {
                    break;
                }
                System.out.print(matrix[rowEnd][j] + " ");
            }
            rowEnd--;

            // 4. Traverse Up along the leftmost column with 'if' inside the loop
            for (int i = rowEnd; i >= rowStart; i--) {
                if (colStart == colEnd) {
                    break;
                }
                System.out.print(matrix[i][colStart] + " ");
            }
            colStart++;
        }
    }

    public static void main(String arg[]) {
        int x = 1;
        int matrix[][] = new int[2][3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = x;
                x++;
            }
        }
        // Spiral(matrix);
        System.out.println();
        OPSpiral(matrix);

    }
}
