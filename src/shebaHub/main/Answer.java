package shebaHub.main;

import java.time.LocalDateTime;
import java.util.List;

public class Answer extends Post{
    private Question question;

    public Answer(Long postId, String content, LocalDateTime postedDate, User user, Question question ) {
        super(postId, content, postedDate, user);
        this.question = question;
    }
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
