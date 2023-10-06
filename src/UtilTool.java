import java.util.Scanner;

public class UtilTool {

    Scanner sc;
    public String input(String message) {
        System.out.print(message);
        return sc.nextLine();
    }
}
