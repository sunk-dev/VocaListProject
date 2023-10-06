package Muti;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MutiQuizView{


    private final ArrayList<String> copyWord;
    private final ArrayList<String> copyWordMeaning;

    public MutiQuizView(ArrayList<String> word, ArrayList<String> wordMeaning) {
        this.copyWord=new ArrayList<String>(word);
        this.copyWordMeaning=new ArrayList<String>(wordMeaning);
        QuizView();
    }
    void QuizView(){
        System.out.println("-----------------------------------------");
        PickAnswer();
        System.out.println("------------------------------------------");
    }

    void PickAnswer(){
        Random random = new Random();
        int wordlen=copyWord.size();
        ArrayList<Integer> IndexBusket=new ArrayList<Integer>();
        while(IndexBusket.size()!=wordlen){
            int answerIndex= random.nextInt(wordlen);
            if (!IndexBusket.contains(answerIndex)){
                IndexBusket.add(answerIndex);
                System.out.println(answerIndex);
            }
        }

    }
}
