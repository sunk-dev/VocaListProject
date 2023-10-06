package Muti;

import java.util.Scanner;

public class tools {
    public tools() {
    }

    public String input(String message) {
        Scanner sc= new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }
}
