<<<<<<< Updated upstream
//package Sub;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class SubQuizRun {
//
//    private int result = 0; //맞은개수 저장.
//    private String menuString; //메뉴항목
//    private int qTotalOuput; //출력 퀴즈수
////    private QuizDataDAO quizData; //문제들을 저장하는 ArrayList
//
//    //생성자
//    public SubQuizRun() {
//        this(5); //퀴즈 출력개수는 디폴트 5개
//    }
//    public SubQuizRun(int size) {
////        quizData = new QuizDataDAO();
//        qTotalOuput = size;
//    }
//
//
//    /**메뉴 보여주기*/
//    public void showMenu(){
//        Scanner scn = new Scanner(System.in);
//        String[] menuStringList =new String[]{"일반상식","연극/영화","수능","스포츠"};
//        while (true) {
//            System.out.println();
//            System.out.println("===== Mini Quiz Start====");
//            System.out.println("1) 일반상식  2) 연극/영화");
//            System.out.println("3) 수능      4) 스포츠   ");
//            System.out.println("5) 종료 ");
//            System.out.print("===메뉴를 선택해주세요===\n:");
//
//            try {
//                int key = scn.nextInt();    //메뉴를 입력받는다.
//                switch (key) {
//                    case 1: case 2: case 3: case 4:
//
//                        System.out.println(key + "번 메뉴를 선택하였습니다.");
//                        menuString = menuStringList[key-1];
//                        if(quizData.loadQuiz(key)) continue;
//                        //해당항목의 퀴즈파일을 로드후 Arraylist에 저장
//                        //파일이 없을경우 아래문장을 실행하지 않고 다시 메뉴화면으로.
//
//                        startQuiz(); //퀴즈 시작
//                        System.out.println("메뉴를 보시려면 아무키나 눌러주세요!");
//                        scn.nextLine();
//                        scn.nextLine();
//                        break;
//
//                    case 5:
//                        System.out.println("프로그램 종료합니다.");
//                        System.exit(0);
//                        break;
//
//                    default:
//                        throw new InputMismatchException();
//                }// switch
//            } catch (InputMismatchException e) {
//                System.out.println("잘못 입력하셨습니다.!");
//                scn.nextLine();
//            }
//        }// while
//
//    }//showMenu()----------
//
//
//    /**퀴즈 시작*/
//    private void startQuiz() {
//        System.out.println("#퀴즈를 시작합니다!");
//        Scanner scn = new Scanner(System.in);
//        if(qTotalOuput>quizData.size()) qTotalOuput = quizData.size();
//        for (int i = 0; i < qTotalOuput; i++) {
//            QuestionDTO qDTO = quizData.get(i);
//            String question = qDTO.getQuestion();
//            String answer = qDTO.getAnswer();
//
//            System.out.println((i + 1) + ") " + question);
//            String user_Answer = scn.nextLine();
//
//            if (answer.equals(user_Answer)) {
//                System.out.println("#정답입니다. 짝!짝");
//                result++;
//            } else {
//                System.out.println("#틀렸습니다. 흐!흑");
//            }
//            System.out.println();
//        }//for()------
//        System.out.println("#퀴즈를 다 풀었습니다.");
//        quizData.clear(); //퀴즈데이터 초기화
//        showResult(); //결과 출력
//
//    }//startQuiz()---------
//
//    /**게임 결과 보기*/
//    public void showResult(){
//
//        System.out.println("===== Mini Quiz Result====");
//        System.out.println("종  목 : "+menuString);
//        System.out.println("문제수 : "+qTotalOuput);
//        System.out.println("정답수 : "+result);
//        System.out.printf("점  수 : %.1f 점\n",result*(100.0/qTotalOuput));
//        System.out.println("==========================");
//    }//showResult()---------
//}
=======
package Sub;

import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SubQuizRun {
   
}
>>>>>>> Stashed changes
