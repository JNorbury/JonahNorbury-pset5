package jnorbury.jonahnorbury_pset5;

/**
 * Created by jonah on 30-Nov-16.
 */

public class GroceryItem extends TodoItem {
    private double weight;

    public GroceryItem(String name, double weight) {
        super(null, name, false);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
