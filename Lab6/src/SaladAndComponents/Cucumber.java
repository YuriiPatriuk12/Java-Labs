package SaladAndComponents;

/**
 * Клас, що представляє огірок, який є підкласом овочу.
 * Успадковує властивості та методи класу {@link Vegetable}.
 */
public class Cucumber extends Vegetable{
    /**
     * Конструктор для створення огірка з заданими вагою, калорійністю та сортом.
     *
     * @param weight    вага у грамах
     * @param calories  кількість калорій на 100 грамів
     * @param variety   сорт
     */
    public Cucumber(double weight, double calories, String variety) {
        super(weight, calories, variety);
    }
}
