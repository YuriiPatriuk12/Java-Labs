package SaladAndComponents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Клас, що представляє салат, який складається з овочів.
 */
public class Salad {

    // Список інгредієнтів салату
    private final List<Vegetable> ingredients;

    /**
     * Конструктор для створення салату з переданими овочами.
     *
     * @param vegetables масив овочів, які додаються до салату
     */
    public Salad(Vegetable... vegetables) {
        this.ingredients = new ArrayList<>();
        Collections.addAll(ingredients, vegetables);
    }

    /**
     * Додає новий овоч до списку інгредієнтів салату.
     *
     * @param component овоч, який додається до салату
     */
    public void addComponent(Vegetable component) {
        this.ingredients.add(component);
    }

    /**
     * Повертає список всіх інгредієнтів (овочів) салату.
     *
     * @return список овочів, що складають салат
     */
    public List<Vegetable> getComponents() {
        return ingredients;
    }

    /**
     * Виводить на екран всі інгредієнти салату, з їх описом.
     */
    public void showComponents() {
        for (Vegetable ingredient : ingredients) {
            System.out.println(ingredient + "\n");
        }
    }

    /**
     * Шукає овоч у салаті, калорійність якого знаходиться в межах заданих значень.
     *
     * @param leftBound   мінімальна межа калорійності
     * @param rightBound  максимальна межа калорійності
     * @return овоч, що задовольняє умови, або null, якщо такий не знайдений
     */
    public Vegetable findVegetable(double leftBound, double rightBound) {
        for (Vegetable vegetable : ingredients) {
            if (vegetable.calculateTotalCalories() >= leftBound && vegetable.calculateTotalCalories() <= rightBound)
                return vegetable;
        }
        return null;
    }
}
