package jnorbury.jonahnorbury_pset5;

/**
 * Created by jonah on 01-Dec-16.
 */

public class HomeworkItem extends TodoItem {
    // homeworkitems also store a due date
    private String due_date;

    public HomeworkItem(String name, String due_date) {
        super(null, name, false);
        this.due_date = due_date;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }
}
