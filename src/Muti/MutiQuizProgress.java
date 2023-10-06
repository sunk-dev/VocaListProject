package Muti;
import java.util.ArrayList;
import java.util.Random;

public class MutiQuizProgress {
    static ArrayList<Integer> IndexBusket=new ArrayList<Integer>();
    public MutiQuizProgress(int wordlen) {
        mainProgress();

    }

    private void mainProgress() {
        while(IndexBusket.size()!=wordlen){
            ArrayList<Integer> Temphoices=PickAnswer(wordlen);

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
        int answerIndex= random.nextInt(wordlen);
        if (!IndexBusket.contains(answerIndex)){
            IndexBusket.add(answerIndex);
            ChoicesIndex.add(answerIndex);

        }
        //일단 기본 4개 선택지.
        for (int i = 0; i < 3; i++) {
            int anotherChoiceIndex=random.nextInt(wordlen);
            if(anotherChoiceIndex!=answerIndex){
                ChoicesIndex.add(anotherChoiceIndex);
            }

        }
        return ChoicesIndex;
    }
}
