package muti;

import java.util.Scanner;

public class tools {


    public static String input(String message) {
        Scanner sc= new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }
}
