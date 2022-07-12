package shebaHub;

import java.util.List;

public class Answer extends Post{
    private Qiuestion qutionn;
    private List<Vote> votes;

    public Qiuestion getQutionn() {
        return qutionn;
    }

    public void setQutionn(Qiuestion qutionn) {
        this.qutionn = qutionn;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public Answer(Qiuestion qutionn, List<Vote> votes) {
        this.qutionn = qutionn;
        this.votes = votes;
    }
}
