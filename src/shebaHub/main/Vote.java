package shebaHub.main;

public class Vote {
    private Long voteId;
    private User user;
    private Post post;

    public Vote(Long voteId, User user, Post post) {
        this.voteId = voteId;
        this.user = user;
        this.post = post;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
