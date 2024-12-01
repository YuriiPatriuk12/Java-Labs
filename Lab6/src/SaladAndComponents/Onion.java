package SaladAndComponents;

/**
 * Клас, що представляє цибулю, який є підкласом овочу.
 * Успадковує властивості та методи класу {@link Vegetable}.
 */
public class Onion extends Vegetable{
    /**
     * Конструктор для створення цибулі із заданими вагою, калорійністю та сортом.
     *
     * @param weight    вага у грамах
     * @param calories  кількість калорій на 100 грамів
     * @param variety   сорт
     */
    public Onion(double weight, double calories, String variety) {
        super(weight, calories, variety);
    }
}
