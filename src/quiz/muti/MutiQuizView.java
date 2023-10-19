package quiz.muti;

import word.WordRepository;


public class MutiQuizView {



    public MutiQuizView(WordRepository wr) {
        QuizView(wr);
    }

    void QuizView(WordRepository wr) {
        wr.ShowMutiQuiz();

    }
}
