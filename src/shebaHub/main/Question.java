package shebaHub.main;

import java.util.List;

public class Question extends Post{

    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Question(List<Category> categories) {
        this.categories = categories;
    }
}
