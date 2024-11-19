/**
 * Головний клас для демонстрації роботи класу {@code StringManager}.
 * Виконує обробку рядка відповідно до завдання за допомогою методу {@code task()}.
 */
public class Main {
    public static void main(String[] args) {
        // Вхідний рядок для обробки
        String str = "lmrem imsum, dolor sit amet, consrctrtur adipiscing telit?! I wtant to brekak freee";

        // Виведення вхідного рядка
        System.out.println(str);

        // Створення екземпляра класу StringManager
        StringManager manager = new StringManager();

        // Виведення обробленого рядка
        System.out.println(manager.task(str));
    }
}
