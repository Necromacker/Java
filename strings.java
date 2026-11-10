import java.util.*;

public class strings {

    // Palindrome
    public static void palindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                System.out.println("Not palindrome");
                break;
            }
            start++;
            end--;
        }
    }

    // Distance
    public static void Distance(String str) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (letter == 'N') {
                y++;
            } else if (letter == 'S') {
                y--;
            } else if (letter == 'E') {
                x++;
            } else {
                x--;
            }
        }
        System.out.println(Math.sqrt((x * x) + (y * y)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Distance(str);
    }
}
