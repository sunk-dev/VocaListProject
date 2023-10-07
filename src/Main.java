import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        try {
            new QuizView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}