package jnorbury.jonahnorbury_pset5;

/**
 * Created by Norbury on 28-Nov-16.
 */
public class NotUsefulStringManager {
    private static NotUsefulStringManager ourInstance = new NotUsefulStringManager();
    private static String superUsefulString;

    public static NotUsefulStringManager getInstance() {
        return ourInstance;
    }

    // counstructor is private!
    private NotUsefulStringManager() {
        superUsefulString = "This is the initial String";
    }

    public void setSuperUsefulString(String newString) {
        superUsefulString = newString;
    }

    public String getSuperUsefulString(){
        return superUsefulString;
    }
}