package shebaHub;

import java.util.List;

public class Answer extends Post{
    private Question qutionn;
    private List<Vote> votes;

    public Question getQutionn() {
        return qutionn;
    }

    public void setQutionn(Question qutionn) {
        this.qutionn = qutionn;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public Answer(Question qutionn, List<Vote> votes) {
        this.qutionn = qutionn;
        this.votes = votes;
    }
}
