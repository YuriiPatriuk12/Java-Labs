import java.util.Arrays;
import java.util.Comparator;

/**
 * Клас {@code CosmeticManager} керує масивом косметичних продуктів.
 * Він дозволяє сортувати продукти за різними критеріями та шукати конкретний об'єкт у масиві.
 */
public class CosmeticManager {

    //Масив косметичних продуктів
    private final Cosmetic[] cosmetics;

    /**
     * Конструктор класу {@code CosmeticManager}, який ініціалізує масив косметичних продуктів.
     */
    public CosmeticManager() {
        cosmetics = new Cosmetic[]{
                new Cosmetic("Lipstick", "BrandA", 15.99, "Red", true),
                new Cosmetic("Foundation", "BrandB", 25.49, "Beige", false),
                new Cosmetic("Mascara", "BrandC", 12.99, "Black", true),
                new Cosmetic("Eyeliner", "BrandA", 8.99, "Brown", false),
                new Cosmetic("Blush", "BrandD", 19.99, "Pink", true)
        };
    }

    /**
     * Демонструє роботу класу: сортування масиву, пошук об'єкта та виведення інформації.
     */
    public void showExample() {
        String separator = "---------------------------";
        System.out.println("Cosmetics:");
        printArray(cosmetics);

        System.out.println(separator);
        System.out.println("Sorted by Price ascending:");
        sortAndShowArray(Comparator.comparing(Cosmetic::getPrice));

        System.out.println(separator);
        System.out.println("Sorted by Brand descending:");
        sortAndShowArray(Comparator.comparing(Cosmetic::getBrand, Comparator.reverseOrder()));

        System.out.println(separator);
        System.out.println("Looking for:");
        Cosmetic target1 = new Cosmetic("Mascara", "BrandC", 12.99, "Black", true);
        target1.displayInfo();
        findElement(target1);

        System.out.println("Looking for:");
        Cosmetic target2 = new Cosmetic("NoName", "EmptyBrand", 0.99, "Black", true);
        target2.displayInfo();
        findElement(target2);
    }

    /**
     * Пошук елемента у масиві.
     *
     * @param target елемент, який потрібно знайти
     */
    private void findElement(Cosmetic target) {
        if (Arrays.asList(cosmetics).contains(target))
            System.out.println("The array do contain this element!");
        else
            System.out.println("The array do not contain this element!");
        System.out.println();
    }

    /**
     * Сортує масив косметичних продуктів за заданою умовою та виводить його.
     *
     * @param comparator компаратор для сортування
     */
    private void sortAndShowArray(Comparator<Cosmetic> comparator) {
        Arrays.sort(cosmetics, comparator);
        printArray(cosmetics);
    }

    /**
     * Виводить інформацію про всі косметичні продукти у масиві.
     *
     * @param inputArray масив косметичних продуктів
     */
    private void printArray(Cosmetic[] inputArray) {
        for (Cosmetic cosmetic : inputArray) {
            cosmetic.displayInfo();
            System.out.println();
        }
    }
}
