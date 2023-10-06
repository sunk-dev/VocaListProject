import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class WordRepository {
    public WordRepository() throws IOException {
        Map<String, String> wordList = new HashMap<String, String>();
        File wordFile = new File("D:\\VocaListProject\\testword1.txt");
        BufferedReader br = new BufferedReader(new FileReader(wordFile));
        String str = br.readLine();
        while(str != null){ // 읽어오는 문자열이 null이 나올때까지 루프
            String[]word=str.split("/");
            wordList.put(word[0],word[1]);
            str = br.readLine(); // 메모장 다음 문자열 읽기
        }
    }
}
