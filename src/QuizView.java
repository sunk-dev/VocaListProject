import Muti.MutiQuizView;

import java.io.IOException;
import java.util.Map;


public class QuizView {
    private final UtilTool utilTool;
    private final WordRepository wr;

    public QuizView() throws IOException {
        this.utilTool = new UtilTool();
        this.wr=new WordRepository();
        viewProcess();

    }
    void mainView() {
        System.out.println("\n★☆★☆Quiz Time☆★☆★");
        System.out.println("퀴즈 모드를 선택해 주세요!");
        System.out.println("1. 객관식 퀴즈");
        System.out.println("2. 주관식 퀴즈");
        System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆");
    }

    void viewProcess() {
        while (true) {
            mainView();
            String menuNum = utilTool.input(">>");

            switch (menuNum) {
                case "1":
                    new MutiQuizView(wr.word,wr.wordMeaning);
                    break;
                case "2":
                    break;
            }
        }
    }
}
