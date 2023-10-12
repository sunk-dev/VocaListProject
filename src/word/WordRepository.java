package word;

import java.io.*;
import java.util.*;

import utility.Utility;


public class WordRepository {

//    public static Map<String, String> wordList;
    public ArrayList<String> word;
    public ArrayList<String> wordMeaning;

    public WordRepository() {
        this.word = new ArrayList<>();
        this.wordMeaning = new ArrayList<>();
        File wordFile = new File("WordList.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(wordFile));
            String str = br.readLine();
            while(str != null){ // 읽어오는 문자열이 null이 나올때까지 루프
                String[]words=str.split(" "); // 기존에 /였던 기준을 띄어쓰기로 수정
                word.add(words[0]);
                wordMeaning.add(words[1]);
                str = br.readLine(); // 메모장 다음 문자열 읽기
            }
        } catch (IOException e) {
            e.printStackTrace();

        }


    }

    /**
     * ShowMutiQuiz()
     * MAXWORDCOUNT:총 단어 개수
     * correctWordIndex: 정답 단어 인덱스 저장.
     * correctWordFare:정답 단어 쌍을 저장해두는 HashMap
     * OptionsList:정답 단어 와 함께 그 외 보기 저장해두는 리스트
     * 
     */

    public void  ShowMutiQuiz() {
        
        Random r =new Random();
        
        final int MAXWORDCOUNT=word.size(); //변하지 않는 함수니 final을 추가함
        int correctWordIndex=r.nextInt(MAXWORDCOUNT);
        
        HashMap<String,String> correctWordFare = new HashMap<>();
        
        correctWordFare.put("word",word.get(correctWordIndex)); //값 추가
        correctWordFare.put("meaning",wordMeaning.get(correctWordIndex));
        
        ArrayList<String> OptionsList = PickChoices(correctWordIndex, MAXWORDCOUNT);
        OptionsList.add(correctWordFare.get("meaning"));
        //보기 무작위 섞기
        Collections.shuffle(OptionsList);


        System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
        System.out.println("\t\t"+correctWordFare.get("word"));
        System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
        for (int i = 0; i <OptionsList.size() ; i++) {
            System.out.println((i+1)+"번 "+OptionsList.get(i));
            System.out.println();
        }
        int userAnswerNum= Integer.parseInt(Utility.input(">>"));
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
