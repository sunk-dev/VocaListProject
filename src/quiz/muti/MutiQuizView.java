package quiz.muti;

import word.WordRepository;


public class MutiQuizView {



    public MutiQuizView() {
        QuizView();
    }

    void QuizView() {
        for (int i = 0; i < WordRepository.word.size(); i++) {
            WordRepository.ShowMutiQuiz();
        }
    }
}
