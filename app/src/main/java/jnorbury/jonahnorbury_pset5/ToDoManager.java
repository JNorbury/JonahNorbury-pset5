package jnorbury.jonahnorbury_pset5;

/**
 * Created by Norbury on 29-Nov-16.
 */
public class ToDoManager {
    private static ToDoManager ourInstance = new ToDoManager();

    public static ToDoManager getInstance() {
        return ourInstance;
    }

    private ToDoManager() {



    }
}
