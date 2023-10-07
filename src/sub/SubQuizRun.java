package sub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SubQuizRun {
    private ArrayList<String> wordList;
    private ArrayList<String> wordMeaning;
    private Random random;
    private Scanner scanner;

    public SubQuizRun(ArrayList<String> wordList, ArrayList<String> wordMeaning) {
        this.wordList = wordList;
        this.wordMeaning = wordMeaning;
        this.random = new Random();
        this.scanner = new Scanner(System.in);
        runQuiz();
    }

    public void runQuiz() {
        int totalQuestions = 5;  // 주관식 문제 5개 선택

        System.out.println("주관식 퀴즈를 시작합니다.");
        for (int i = 0; i < totalQuestions; i++) {
            int randomIndex = random.nextInt(wordList.size());
            String question = wordList.get(randomIndex);
            String correctAnswer = wordMeaning.get(randomIndex);

            System.out.println("문제 " + (i + 1) + ":");
            System.out.println("단어 '" + question + "'의 뜻은 무엇일까요?");

            System.out.print("정답을 입력하세요: ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("정답입니다!");
            } else {
                System.out.println("틀렸습니다. 정답은 '" + correctAnswer + "' 입니다.");
            }
        }
    }
}




