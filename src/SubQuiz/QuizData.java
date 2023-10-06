package SubQuiz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class QuizData extends ArrayList<QuestionSave> {

    public boolean loadQuiz() {


        try {
            

            while (scn.hasNext()) {
                //짝수줄 문제, 홀수줄 정답.
                //문제와 정답을 읽어와서 Arraylist에 추가
                QuestionSave qs = new QuestionSave(scn.nextLine(), scn.nextLine());
                //System.out.println(qDTO);
                this.add(qs);
            }//while------

            System.out.println();
            Collections.shuffle(this); // 문제 섞는다.
            /*
             * for (Question q: QuizData) { System.out.println(q); }
             */

        } catch (FileNotFoundException e) {
            System.out.println("예외 : " + e);
            return true;
        }

        return false;
    }// loadQuiz()

}
