package jnorbury.jonahnorbury_pset5;

/**
 * Created by jonah on 01-Dec-16.
 */

public class AppIdeaItem extends TodoItem {
    private String description;

    public AppIdeaItem(String name, String description) {
        super(null, name, false);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String newdesc) {
        description = newdesc;
    }
}
