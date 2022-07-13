package shebaHub.main;

import java.util.List;

public class Answer extends Post{
    private Question question;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer(Question question, List<Vote> votes) {
        this.question = question;
    }
}
