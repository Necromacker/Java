import java.util.*;

public class basics {

  public static void inverted_half_triangle(int rows) {
    for (int i = 1; i <= rows; i++) {
      for (int j = rows; j >= 1; j--) {
        if (j <= i) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  public static void inverted_half_numbers(int rows) {
    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= (rows - i + 1); j++) {
        System.out.print(j);
      }
      System.out.println();
    }
  }

  public static void main(String arg[]) {
    inverted_half_numbers(5);

  }

}
