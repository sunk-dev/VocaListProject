import java.util.Scanner;

public class UtilTool {


    public String input(String message) {
        Scanner sc= new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }
}
