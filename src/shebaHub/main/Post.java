package shebaHub.main;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Post {
    private Long postId;
    private String content;
    private LocalDateTime postedDate;
    private User user;
    private List<Vote> votes;

    public Post(Long postId, String content, LocalDateTime postedDate, User user) {
        this.postId = postId;
        this.content = content;
        this.postedDate = postedDate;
        this.user = user;

    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDateTime postedDate) {
        this.postedDate = postedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}
