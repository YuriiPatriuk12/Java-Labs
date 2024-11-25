package SaladAndComponents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Salad {
    private final List<Vegetable> ingredients;

    public Salad(Vegetable... vegetables) {
        this.ingredients = new ArrayList<>();
        Collections.addAll(ingredients, vegetables);
    }

    public void addComponent(Vegetable component) {
        this.ingredients.add(component);
    }

    public List<Vegetable> getComponents() {
        return ingredients;
    }

    public void showComponents() {
        for (Vegetable ingredient : ingredients) {
            System.out.println(ingredient + "\n");
        }
    }

    public Vegetable findVegetable(double leftBound, double rightBound) {
        for(Vegetable vegetable : ingredients)
        {
            if(vegetable.calculateTotalCalories() >= leftBound && vegetable.calculateTotalCalories() <= rightBound)
                return vegetable;
        }
        return null;
    }
}
