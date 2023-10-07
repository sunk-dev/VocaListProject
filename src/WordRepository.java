import java.io.*;
import java.util.*;


public class WordRepository {

//    public static Map<String, String> wordList;
    public ArrayList<String> word;
    public ArrayList<String> wordMeaning;

    public WordRepository() throws IOException {
        this.word = new ArrayList<>();
        this.wordMeaning = new ArrayList<>();
        File wordFile = new File("D:\\VocaListProject\\testword1.txt");
        BufferedReader br = new BufferedReader(new FileReader(wordFile));
        String str = br.readLine();
        while(str != null){ // 읽어오는 문자열이 null이 나올때까지 루프
            String[]words=str.split("/");
            word.add(words[0]);
            wordMeaning.add(words[1]);
            str = br.readLine(); // 메모장 다음 문자열 읽기
        }


    }

    /**
     * 1개의 객관식 문제를 만들어주는 클래스
     * @param Word
     * @param WordMeaning
     * correctWordFare 단어, 뜻 순서
     */

    String  MutiProgress() {
        Random r =new Random();
        int MAXWORDCOUNT=word.size();
        int correctWordIndex=r.nextInt(MAXWORDCOUNT);
        HashMap<String,String> correctWordFare = new HashMap<>();//new에서 타입 파라미터 생략가능
        correctWordFare.put("word",word.get(correctWordIndex)); //값 추가
        correctWordFare.put("meaning",wordMeaning.get(correctWordIndex));
        System.out.println(PickChoices(correctWordIndex,MAXWORDCOUNT));

        return String.format("문제양식");

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
            if (OptionIndex!= correctWordIndex){
                String optionWordMeaning= wordMeaning.get(OptionIndex);
                OptionWordList.add(optionWordMeaning);
            }
        }

        return OptionWordList;
    }


}
