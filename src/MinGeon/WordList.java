package MinGeon;

import java.util.ArrayList;

public class WordList {
    static ArrayList<String> wordList = new ArrayList<>();

    /**
     * addWord
     * 단어장에 단어를 추가하는 메서드
     * @param word - 추가하려는 단어
     */
    static void addWord(String word) {
        wordList.add(word);
    }

    /**
     * exportWordList
     * 단어장에 저장된 단어와 뜻 리스트를 내보내는 메서드
     * @return word : ArrayList를 String 형태로 저장해서 보내준다.
     *
     */
    static String exportWordList() {
        String word = "";
        for (String s : wordList) {
            word = word + s;
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
    static boolean wordEqualCheck(String addWord) {
        for (String word : wordList) {
            if(addWord.equals(word.substring(0,word.indexOf(" "))))
                return true;
        }
        return false;
    }
}
