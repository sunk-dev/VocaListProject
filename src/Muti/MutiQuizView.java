package Muti;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MutiQuizView{

    private final MutiQuizProgress mp;
    private final ArrayList<String> copyWord;
    private final ArrayList<String> copyWordMeaning;

    public MutiQuizView(ArrayList<String> word, ArrayList<String> wordMeaning) {
        this.mp=new MutiQuizProgress(word.size());
        this.copyWord=new ArrayList<String>(word);
        this.copyWordMeaning=new ArrayList<String>(wordMeaning);
        QuizView();
    }
    void QuizView(){
        System.out.println("-----------------------------------------");
        mp.mainProgress(copyWord,copyWordMeaning);
        System.out.println("------------------------------------------");
    }




}
