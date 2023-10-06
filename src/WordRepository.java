import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class WordRepository {

//    public static Map<String, String> wordList;
    public ArrayList<String> word;
    public ArrayList<String> wordMeaning;

    public WordRepository() throws IOException {
//        this.wordList = new HashMap<String, String>();
        this.word = new ArrayList<>();
        this.wordMeaning = new ArrayList<>();
        File wordFile = new File("C:\\Users\\jskre\\VocaListProject\\testword1.txt");
        BufferedReader br = new BufferedReader(new FileReader(wordFile));
        String str = br.readLine();
        while(str != null){ // 읽어오는 문자열이 null이 나올때까지 루프
            String[]words=str.split("/");
            word.add(words[0]);
            wordMeaning.add(words[1]);
            str = br.readLine(); // 메모장 다음 문자열 읽기
        }

    }
}
