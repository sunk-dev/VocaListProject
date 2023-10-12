package quiz;

import java.io.IOException;

public class Main {
    public Main() {
        try {
            new QuizView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}