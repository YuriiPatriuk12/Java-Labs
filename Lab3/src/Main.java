/**
 * Головний клас програми, який демонструє роботу з косметичними продуктами
 * за допомогою класу {@link CosmeticManager}.
 */
public class Main {

    /**
     * Головний метод програми. Використовується для ініціалізації та виклику методів {@link CosmeticManager}.
     *
     * @param args аргументи командного рядка (не використовуються у цій програмі)
     */
    public static void main(String[] args) {
        // Створення об'єкта класу  CosmeticManager
        CosmeticManager cm = new CosmeticManager();

        // Демонстрація функціоналу CosmeticManager
        cm.showExample();
    }
}
