package shebaHub;

import java.util.List;

public class Answer extends Post{
    private Question question;
    private List<Vote> votes;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public Answer(Question question, List<Vote> votes) {
        this.question = question;
        this.votes = votes;
    }
}
