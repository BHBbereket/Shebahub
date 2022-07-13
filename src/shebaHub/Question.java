package shebaHub;

import java.util.List;

public class Question extends Post{
    private List<Cotegory> cotegories;

    public List<Cotegory> getCotegories() {
        return cotegories;
    }

    public void setCotegories(List<Cotegory> cotegories) {
        this.cotegories = cotegories;
    }

    public Question(List<Cotegory> cotegories) {
        this.cotegories = cotegories;
    }
}
