import SaladAndComponents.*;

/**
 * Клас SaladManager відповідає за керування салатом.
 * Надає функціонал відповідно до завдання
 */
public class SaladManager {
    private final Salad salad;

    /**
     * Конструктор класу SaladManager.
     * Ініціалізує салат із попередньо заданими інгредієнтами.
     */
    public SaladManager() {
        salad = new Salad(
                new Onion(30, 34.5, "White"),
                new Cucumber(45.6, 13, "Persian"),
                new Tomato(150, 20.34, "Rose"),
                new Lettuce(130, 12.3, "Green")
        );
    }

    /**
     * Демонструє функціональність класу SaladManager.
     */
    public void test(){
        showSaladComponents();

        System.out.printf("Total salad calories: %.2f%n", calculateTotalCalories());

        findVegetableByCalories(1,10);
        findVegetableByCalories(100,10);
    }

    /**
     * Обчислює загальну кількість калорій салату.
     *
     * @return загальна калорійність усіх інгредієнтів салату.
     */
    public double calculateTotalCalories() {
        double result = 0;

        for(Vegetable vegetable : salad.getComponents())
        {
            result += vegetable.calculateTotalCalories();
        }

        return result;
    }

    /**
     * Знаходить і відображає овоч із загальною калорійністю в заданому діапазоні.
     *
     * @param leftBound  нижня межа діапазону калорій включно.
     * @param rightBound верхня межа діапазону калорій включно.
     */
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

    /**
     * Виводить компоненти салату на консоль.
     */
    public void showSaladComponents(){
        System.out.println("-------------------Salad----------------------");
        salad.showComponents();
    }
}
