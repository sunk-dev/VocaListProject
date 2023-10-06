package SubQuiz;

public class QuestionSave {
    private String question;
    private String answer;


    public QuestionSave() {

    }

    public QuestionSave(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }


    public String getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Question [question=" + question + ", answer=" + answer + "]";
    }
}
