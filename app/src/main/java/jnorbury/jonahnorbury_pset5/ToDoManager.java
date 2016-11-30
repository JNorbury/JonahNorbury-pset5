package jnorbury.jonahnorbury_pset5;

import java.util.ArrayList;

/**
 * Created by Norbury on 29-Nov-16.
 */
public class ToDoManager {
    private static ArrayList<ToDoList> allLists;
    private static ToDoManager ourInstance = new ToDoManager();

    public static ToDoManager getInstance() {
        return ourInstance;
    }

    public static void addList(ToDoList t) {
        allLists.add(t);
    }

    private ToDoManager() {
        allLists = new ArrayList<ToDoList>();
    }

    public static ArrayList<ToDoList> getlist() {
        return allLists;
    }
}
