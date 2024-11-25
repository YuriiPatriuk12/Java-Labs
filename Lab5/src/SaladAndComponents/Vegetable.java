package SaladAndComponents;

/**
 * Абстрактний клас, який представляє овочі.
 * Містить основні властивості та методи для розрахунку калорійності та опису овочів.
 */
public abstract class Vegetable {

    // Вага овочу у грамах
    private double weight;

    // Кількість калорій на 100 грамів
    private double caloriesPer100Gram;

    // Сорт овочу
    private String variety;

    /**
     * Базовий конструктор.
     * Ініціалізує калорійність на 100 грамів значенням 0.
     */
    protected Vegetable() {
        caloriesPer100Gram = 0;
    }

    /**
     * Конструктор з параметрами.
     *
     * @param weight               вага овочу у грамах
     * @param caloriesPer100Gram   кількість калорій на 100 грамів
     * @param variety              сорт овочу
     */
    protected Vegetable(double weight, double caloriesPer100Gram, String variety) {
        this.weight = weight;
        this.caloriesPer100Gram = caloriesPer100Gram;
        this.variety = variety;
    }

    /**
     * Розраховує загальну кількість калорій для овочу.
     *
     * @return загальна кількість калорій
     */
    public double calculateTotalCalories() {
        return (caloriesPer100Gram * weight) / 100;
    }

    /**
     * Повертає текстовий опис овочу.
     *
     * @return текстовий опис овочу
     */
    @Override
    public String toString() {
        return String.format("%s\nWeight: %.2f \nCalories per 100 grams: %.2f \nTotal calories: %.2f \nVariety: %s",
                getClass().getSimpleName(), weight, caloriesPer100Gram, calculateTotalCalories(), variety);
    }
}
