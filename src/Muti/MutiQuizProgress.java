package Muti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;


public class MutiQuizProgress {
    static ArrayList<Integer> IndexBusket=new ArrayList<Integer>();
    tools t= new tools();

    public MutiQuizProgress(int wordlen) {



    }

    void  mainProgress(ArrayList<String> Word, ArrayList<String> WordMeaning) {
        while(IndexBusket.size()!=15){
            ArrayList<Integer> Temphoices=PickAnswer(15);
            String CorretAnswerWord=Word.get(Temphoices.get(0));
            System.out.println("===============================================");
            System.out.println("                 ["+CorretAnswerWord+"]                  ");
            Collections.shuffle(Temphoices);
            for (int i = 0; i <4 ; i++) {
                String AnswerCandidate=WordMeaning.get(Temphoices.get(i));
                System.out.println("===========================================");
                System.out.println((i+1)+"번: "+AnswerCandidate);
                System.out.println("===========================================");

            }
            String UserAnswer=t.input(">>");
            int UserPickIndex=Integer.parseInt(UserAnswer)-1;
            if(CorretAnswerWord.equals(Word.get(Temphoices.get(UserPickIndex)))){
                System.out.println("정답입니다!");
            }
            else{
                System.out.println("틀렸습니다!");

            }

        }
    }

    /**
     * @param
     * @param size
     * @return answerIndex : 문제 정답 인덱스 반환
     */
    ArrayList<Integer> PickAnswer(int size){
        Random random = new Random();
        ArrayList<Integer> ChoicesIndex=new ArrayList<Integer>();
        int answerIndex= random.nextInt(15);
        if (!IndexBusket.contains(answerIndex)){
            IndexBusket.add(answerIndex);
            ChoicesIndex.add(answerIndex);

        }
        //일단 기본 4개 선택지.
        for (int i = 0; i < 3; i++) {
            int anotherChoiceIndex=random.nextInt(15);
            if(anotherChoiceIndex!=answerIndex){
                ChoicesIndex.add(anotherChoiceIndex);
            }

        }
        return ChoicesIndex;
    }


}
