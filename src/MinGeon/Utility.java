package MinGeon;

import java.util.Scanner;

public class Utility {
    static Scanner sc = new Scanner(System.in);
    public static String input(String message) {
        System.out.print(message);
        return sc.nextLine();
    }
}
