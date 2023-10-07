package word;

import java.io.*;
import java.util.*;

import muti.tools;
import muti.tools.*;


public class WordRepository {

//    public static Map<String, String> wordList;
    public ArrayList<String> word;
    public ArrayList<String> wordMeaning;

    public WordRepository() {
        this.word = new ArrayList<>();
        this.wordMeaning = new ArrayList<>();
<<<<<<< Updated upstream:src/word/WordRepository.java
        File wordFile = new File("D:\\VocaListProject\\testword1.txt");


        try {
            BufferedReader br = new BufferedReader(new FileReader(wordFile));
            String str = br.readLine();
            while(str != null){ // 읽어오는 문자열이 null이 나올때까지 루프
                String[]words=str.split("/");
                word.add(words[0]);
                wordMeaning.add(words[1]);
                str = br.readLine(); // 메모장 다음 문자열 읽기
            }
        } catch (IOException e) {
            e.printStackTrace();
=======
        File wordFile = new File("C:\\Users\\cyci\\Desktop\\Git\\VocaListProject\\testword1.txt");
        BufferedReader br = new BufferedReader(new FileReader(wordFile));
        String str = br.readLine();
        while(str != null){ // 읽어오는 문자열이 null이 나올때까지 루프
            String[]words=str.split("/");
            word.add(words[0]);
            wordMeaning.add(words[1]);
            str = br.readLine(); // 메모장 다음 문자열 읽기
>>>>>>> Stashed changes:src/WordRepository.java
        }


    }

    /**
     * 1개의 객관식 문제를 만들어주는 클래스
     * @param Word
     * @param WordMeaning
     * correctWordFare 단어, 뜻 순서
     */

    public void  ShowMutiQuiz() {
        Random r =new Random();
        int MAXWORDCOUNT=word.size();
        int correctWordIndex=r.nextInt(MAXWORDCOUNT);
        HashMap<String,String> correctWordFare = new HashMap<>();//new에서 타입 파라미터 생략가능
        correctWordFare.put("word",word.get(correctWordIndex)); //값 추가
        correctWordFare.put("meaning",wordMeaning.get(correctWordIndex));
        ArrayList<String> OptionsList = PickChoices(correctWordIndex, MAXWORDCOUNT);
        OptionsList.add(correctWordFare.get("meaning"));
        Collections.shuffle(OptionsList);

        System.out.println("============================================");
        System.out.println("\t"+correctWordFare.get("word"));
        System.out.println("=============================================");
        for (int i = 0; i <OptionsList.size() ; i++) {
            System.out.println((i+1)+"번 "+OptionsList.get(i));
            System.out.println();
        }
        int userAnswerNum= Integer.parseInt(tools.input(">>"));
        String userAnswer=OptionsList.get(userAnswerNum-1);
        if(correctWordFare.get("meaning").equals(userAnswer)){
            System.out.println("정답입니다!");
        }else{
            System.out.println("틀렸습니다. 정답은 >>"+correctWordFare.get("meaning"));
        }



    }

    /**
     * 정답외의 선택지 출력
     * 일단 4지선다로
     * @param correctWordIndex
     * @return
     */
    ArrayList<String> PickChoices(int correctWordIndex,int MAXWORDCOUNT){
        Random r = new Random();
        ArrayList<String> OptionWordList= new ArrayList<>();
        while(OptionWordList.size()!=3){
            int OptionIndex=r.nextInt(MAXWORDCOUNT);
            if (OptionIndex!= correctWordIndex && !OptionWordList.contains(wordMeaning.get(OptionIndex))){
                String optionWordMeaning= wordMeaning.get(OptionIndex);
                OptionWordList.add(optionWordMeaning);
            }
        }

        return OptionWordList;
    }

    public String CheckAnswer(int userAnserNum){

        return String.format("");

    }


}
