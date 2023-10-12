package quiz;

import word.WordRepository;

import java.io.IOException;


/**
 * 테스트 하는 곳
 */
public class test {
    public static void main(String[] args) throws IOException {
        WordRepository wr=new WordRepository();
        System.out.println(wr.word);
        System.out.println(wr.wordMeaning);
        wr.ShowMutiQuiz();
    }
}
