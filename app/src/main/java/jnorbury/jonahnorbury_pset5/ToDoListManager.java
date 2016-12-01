package jnorbury.jonahnorbury_pset5;

import java.util.ArrayList;

/**
 * Created by Norbury on 29-Nov-16.
 */
public class ToDoListManager {
    private static ArrayList<ToDoList> allLists;
    private static ToDoListManager ourInstance = new ToDoListManager();

    public static ToDoListManager getInstance() {
        return ourInstance;
    }

    private ToDoListManager() {
        allLists = new ArrayList<ToDoList>();
    }

    public static void addList(ToDoList t) {
        allLists.add(t);
    }

    public static ArrayList<ToDoList> getAllLists() {
        return allLists;
    }
}
