package muti;

import word.WordRepository;
import muti.tools.*;


public class MutiQuizView {



    public MutiQuizView(WordRepository wr) {
        QuizView(wr);
    }

    void QuizView(WordRepository wr) {
        for (int i = 0; i < wr.word.size(); i++) {
            wr.ShowMutiQuiz();
        }

    }


}
