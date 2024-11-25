import SaladAndComponents.*;

import java.util.Comparator;

public class SaladManager {
    private final Salad salad;

    public SaladManager() {
        salad = new Salad(
                new Onion(30, 34.5, "White"),
                new Cucumber(45.6, 13, "Persian"),
                new Tomato(150, 20.34, "Rose"),
                new Lettuce(130, 12.3, "Green")
        );
    }

    public void test(){
        showSaladComponents();
        sortByTotalCalories();
        showSaladComponents();

        System.out.printf("Total salad calories: %.2f%n", calculateTotalCalories());

        findVegetableByCalories(1,10);
        findVegetableByCalories(100,10);
    }

    public double calculateTotalCalories() {
        double result = 0;

        for(Vegetable vegetable : salad.getComponents())
        {
            result += vegetable.calculateTotalCalories();
        }

        return result;
    }

    public void sortByTotalCalories() {
        salad.getComponents().sort(Comparator.comparing(Vegetable::calculateTotalCalories));
        System.out.println("Salad has been sorted by total calories\n");
    }

    public void findVegetableByCalories(double leftBound, double rightBound) {
        if(leftBound > rightBound) {
            System.out.println("Left bound cannot be greater than right bound!");
            return;
        }

        Vegetable v = salad.findVegetable(leftBound, rightBound);
        if(v != null)
        {
            System.out.println("Vegetable is found!");
            System.out.println(v);
        }
        else
            System.out.println("Vegetable is not found!");

    }

    public void showSaladComponents(){
        System.out.println("-------------------Salad----------------------");
        salad.showComponents();
    }
}
