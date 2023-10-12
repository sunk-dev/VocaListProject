package quiz;

import java.io.IOException;

public class quizMain {
    public quizMain() {
        try {
            new QuizView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}