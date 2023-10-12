package VocaMain;

import MinGeon.PlusWord;
import quiz.*;
import utility.Utility;


public class VocaView {

    private static VocaFile vocaFile; // VocaFile 객체를 클래스 레벨로 이동


    public static void start(){

        vocaFile = new VocaFile();//1번 선택 전에 VocaFile 객체 생성 ( 파일 생성)


        while (true){
            System.out.println("\n\n****** 👨‍💻Voca 프로그램👩‍💻 ******");
            System.out.println("#1. 단어장 보기!👀");
            System.out.println("#2. 문제 풀기!😊");
//            System.out.println("#3. 주관식 문제 풀기!🙂"); -- 문제 풀기메뉴 안에서 객관식 주관식 선택하기로 변경했습니다!
            System.out.println("#3. 새로운 단어 추가!🧠");
            System.out.println("#4. Voca 프로그램 종료🙌");

            Utility.makeLine();

            String menuNum = Utility.input(">>");

            switch (menuNum) {
                case "1":
                    vocaFile.FileWrite(); //1번 선택시 txt파일에 단어 자동 저장 하기
                    vocaFile.loadFile(); //1번 선택시 txt파일에 있는 단어 불러오기
                    break;
                case "2":
                    new quizMain();
                    break;
                case "3":
                    new PlusWord();
                    break;
                case "4":
                    System.out.println("수고하셨습니다!👍");
                    System.exit(0);
                default:
                    System.out.println("# 입력 하신 메뉴번호가 잘못 됐습니다!😅");
            }
        }
    }
}
