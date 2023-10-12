package MinGeon;

import utility.Utility;

import java.io.*;

import static utility.Utility.input;

public class PlusWord {
//    static final String ROOT_PATH = "D:";

    public PlusWord() {
        File file = new File("WordList.txt");
        FileReader fileReader = null;
        String word = "";
        String wordMean = "";

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("파일 생성 실패!");
                return;
            }
        }

        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("파일 불러오기 실패!");
            return;
        }

        try (BufferedReader buffRead = new BufferedReader(fileReader)) {
            String line;
            String addWord;
            while((line = buffRead.readLine()) != null) {
                addWord = line + "\n";
                WordList.addWord(addWord);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("파일 읽어오기 실패!");
            return;
        }

        System.out.println("단어를 추가합니다. 0을 입력시 종료");
        while(true) {
            word = input("단어 입력 : ");
            if(stopCheck(word)) {
                System.out.println("단어 추가를 중지합니다.");
                break;
            }
            if(WordList.wordEqualCheck(word)) {
                System.out.printf("%s는 이미 들어가있는 단어입니다.\n", word);
                continue;
            }
            wordMean = input("단어의 뜻 입력 : ");
            if(stopCheck(wordMean)) {
                System.out.println("단어 추가를 중지합니다.");
                break;
            }
            word = word + " " + wordMean + "\n";
            WordList.addWord(word);
        }

        try (FileWriter fileWriter = new FileWriter(file)) {
            String wordList = WordList.exportWordList();
            fileWriter.write(wordList);
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * stopCheck
     * 단어 추가를 그만두려는지 확인하는 메서드
     * @param checkString - 중지를 확인할 변수
     * @return  true : 단어 추가를 그만둔다.
     *          false : 단어 추가를 계속한다.
     * */
    private boolean stopCheck(String checkString) {
        return checkString.equals("0");
    }
}
