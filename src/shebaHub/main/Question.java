package shebaHub.main;

import java.time.LocalDateTime;
import java.util.List;

public class Question extends Post{

    private List<Category> categories;
    private List<Answer> answers;


    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Question(Long postId, String content, LocalDateTime postedDate, User user) {
        super(postId, content, postedDate, user);
//        this.categories = categories;
    }
}
