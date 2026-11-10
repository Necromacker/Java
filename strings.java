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

    // Uppercase
    public static void Uppercase(String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == ' ') {
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb);
    }

    // String Compression
    public static void Compression(String str) {
        str += " ";
        int count = 1;
        StringBuilder compressed = new StringBuilder("");
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else if (count == 1) {
                compressed.append(str.charAt(i));
            } else {
                compressed.append(str.charAt(i));
                compressed.append(count);
                count = 1;
            }
        }
        System.out.println(compressed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Compression(str);
    }
}
