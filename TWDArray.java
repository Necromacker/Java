import java.util.*;

public class TWDArray {
    public static void main(String arg[]) {
        int Matrix[][] = new int[3][4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                Matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
