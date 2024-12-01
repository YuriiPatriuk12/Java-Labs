package SaladAndComponents;

/**
 * Клас, що представляє помідор, який є підкласом овочу.
 * Успадковує властивості та методи класу {@link Vegetable}.
 */
public class Tomato extends Vegetable{
    /**
     * Конструктор для створення помідора з заданими вагою, калорійністю та сортом.
     *
     * @param weight    вага у грамах
     * @param calories  кількість калорій на 100 грамів
     * @param variety   сорт
     */
    public Tomato(double weight, double calories, String variety) {
        super(weight, calories, variety);
    }
}
