package word;

import java.io.*;
import java.util.*;

import quiz.QuizView;
import utility.Utility;


public class WordRepository {

//    public static Map<String, String> wordList;
    public static ArrayList<String> word;
    public static ArrayList<String> wordMeaning;
    public static ArrayList<String> wordList = new ArrayList<>();

    public WordRepository() {
        this.word = new ArrayList<>();
        this.wordMeaning = new ArrayList<>();
        File wordFile = new File("WordList.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(wordFile));
            String str = br.readLine();
            while(str != null){ // 읽어오는 문자열이 null이 나올때까지 루프
                wordList.add(str);
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

    public static void  ShowMutiQuiz() {
        
        Random r =new Random();
        
        final int MAXWORDCOUNT=word.size(); //변하지 않는 함수니 final을 추가함
        ArrayList<Integer> submittedList=new ArrayList<>();

        int QuizNum=1;

        System.out.println("총"+MAXWORDCOUNT+"개의 문제가 출제됩니다!");
        System.out.println("중간에 그만하고 싶으면 0을 입력하세요!!");

        while (submittedList.size()!=word.size()){
            int correctWordIndex=r.nextInt(MAXWORDCOUNT);
            if(submittedList.contains(correctWordIndex)){
                continue;
            }
            else{
                submittedList.add(correctWordIndex);
                HashMap<String,String> correctWordFare = new HashMap<>();

                correctWordFare.put("word",word.get(correctWordIndex)); //값 추가
                correctWordFare.put("meaning",wordMeaning.get(correctWordIndex));

                ArrayList<String> OptionsList = PickChoices(correctWordIndex, MAXWORDCOUNT);
                OptionsList.add(correctWordFare.get("meaning"));
                //보기 무작위 섞기
                Collections.shuffle(OptionsList);


                System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
                System.out.println("\t\t"+ QuizNum+"번"+correctWordFare.get("word"));
                System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
                for (int i = 0; i <OptionsList.size() ; i++) {
                    System.out.println((i+1)+"번 "+OptionsList.get(i));
                    System.out.println();
                }
                int userAnswerNum=-1;
                String userAnswer="";

                while (true){
                    try{
                        userAnswerNum=Integer.parseInt(Utility.input(">>"));
                        if(userAnswerNum==0){
                            return;
                        }
                        userAnswer=OptionsList.get(userAnswerNum-1);

                    }catch (Exception e){
                        System.out.println("보기에 있는 번호를 입력해주세요!");
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
            QuizNum++;


        }




    }

    /**
     * 정답외의 선택지 출력
     * 일단 4지선다로
     * @param correctWordIndex
     * @return
     */
    static ArrayList<String> PickChoices(int correctWordIndex, int MAXWORDCOUNT){
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
    /**
     * addWord
     * 단어장에 단어를 추가하는 메서드
     * @param w - 추가하려는 단어
     * @param wordMean - 추가하려는 단어의 의미
     */
    public static void addWord(String w, String wordMean) {
        String putWord = w + " " + wordMean;
        word.add(w);
        wordMeaning.add(wordMean);
        wordList.add(putWord);
    }

    /**
     * exportWordList
     * 단어장에 저장된 단어와 뜻 리스트를 내보내는 메서드
     * @return word : ArrayList를 String 형태로 저장해서 보내준다.
     *
     */
    public static String exportWordList() {
        String word = "";
        for (String s : wordList) {
            word = word + s + "\n";
        }
        return word;
    }

    /**
     wordEqaulCheck
     추가하려는 단어가 이미 단어장에 들어가있는지 확인하는 메서드
     @param addWord - 추가하려는 단어
     @return     true : 단어장에 해당 단어가 있음
     false : 단어장에 해당 단어가 없음
     */
    public static boolean wordEqualCheck(String addWord) {
        for (String w : word) {
            if(addWord.equals(w))
                return true;
        }
        return false;
    }

}
