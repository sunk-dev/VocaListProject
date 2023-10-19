package word;

import java.io.*;
import java.util.*;

import quiz.muti.tools;


public class WordRepository {

//    public static Map<String, String> wordList;
    public ArrayList<String> word;
    public ArrayList<String> wordMeaning;

    public WordRepository() {
        this.word = new ArrayList<>();
        this.wordMeaning = new ArrayList<>();
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
        ArrayList<Integer> submittedWordList=new ArrayList<>();
        
        int MAXWORDCOUNT=word.size();
        int Quiznum=1;
        while(submittedWordList.size()!=15){

            int correctWordIndex=r.nextInt(MAXWORDCOUNT);
            if (submittedWordList.contains(correctWordIndex)){
                continue;
            }
            else{
                submittedWordList.add(correctWordIndex);
                HashMap<String,String> correctWordFare = new HashMap<>();
                correctWordFare.put("word",word.get(correctWordIndex)); //값 추가
                correctWordFare.put("meaning",wordMeaning.get(correctWordIndex));
                ArrayList<String> OptionsList = PickChoices(correctWordIndex, MAXWORDCOUNT);
                OptionsList.add(correctWordFare.get("meaning"));
                //보기 무작위 섞기
                Collections.shuffle(OptionsList);



                System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
                System.out.println("\t\t"+Quiznum+"번:"+correctWordFare.get("word"));
                System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
                for (int i = 0; i <OptionsList.size() ; i++) {
                    System.out.println((i+1)+"번 "+OptionsList.get(i));
                    System.out.println();
                }
                int userAnswerNum=-1;
                String userAnswer="";

                while (true){
                    try{
                        userAnswerNum= Integer.parseInt(tools.input(">>"));
                        userAnswer = OptionsList.get(userAnswerNum - 1);

                    }catch (Exception e){
                        System.out.println("보기에 있는 값을 입력해주세요!");
                        continue;

                    }
                    break;

                }


                

                if(correctWordFare.get("meaning").equals(userAnswer)){
                    System.out.println("정답입니다!");
                }else{
                    System.out.println("틀렸습니다. 정답은 >>"+correctWordFare.get("meaning"));
                }




            }
            Quiznum++;

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
