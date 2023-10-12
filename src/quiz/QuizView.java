package quiz;

import utility.Utility;
import word.WordRepository;

import quiz.muti.*;
import quiz.sub.*;



import java.io.IOException;


public class QuizView {
    private final Utility utilTool;
    private final WordRepository wr;

    public QuizView() throws IOException {
        this.utilTool = new Utility();
        this.wr=new WordRepository();
        viewProcess();

    }
    void mainView() {
        System.out.println("\n★☆★☆Quiz Time☆★☆★");
        System.out.println("퀴즈 모드를 선택해 주세요!");
        System.out.println("1. 객관식 퀴즈");
        System.out.println("2. 주관식 퀴즈");
        System.out.println("3. 나가기");
        System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆");
    }

    void viewProcess() {
        while (true) {
            mainView();
            String menuNum = utilTool.input(">>");

            switch (menuNum) {
                case "1":
                    new MutiQuizView(wr);
                    break;
                case "2":
                    new SubQuizRun(wr.word,wr.wordMeaning);
                    break;
                case "3":
                    System.out.println("퀴즈를 종료합니다.");
                    return;
                default:
                    System.out.println("1,2,3 중에서 입력해주세요!");
                    break;
            }
        }
    }
}
