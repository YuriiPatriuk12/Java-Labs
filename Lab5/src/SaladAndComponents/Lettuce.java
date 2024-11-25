package SaladAndComponents;

/**
 * Клас, що представляє листя салату, який є підкласом овочу.
 * Успадковує властивості та методи класу {@link Vegetable}.
 */
public class Lettuce extends Vegetable{

    /**
     * Конструктор для створення листя салату із заданими вагою, калорійністю та сортом.
     *
     * @param weight    вага у грамах
     * @param calories  кількість калорій на 100 грамів
     * @param variety   сорт
     */
    public Lettuce(double weight, double calories, String variety) {
        super(weight, calories, variety);
    }
}
