package utility;

import java.util.Scanner;

public class Utility {
    static Scanner sc = new Scanner(System.in);

    public static void makeLine(){
        System.out.println("==========================");
    }

    public static String input(String message){
        System.out.println(message);
        return sc.nextLine();
    }
}
