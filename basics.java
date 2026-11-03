import java.util.*;

public class basics {

  public static void hollow_square(int rows) {
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

  public static void main(String arg[]) {
    hollow_square(2);
  }

}
