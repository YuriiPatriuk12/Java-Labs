/**
 * Клас {@code Cosmetic} представляє косметичний продукт з властивостями:
 * назва, бренд, ціна, колір та органічність.
 */
public class Cosmetic {

    //Назва продукту
    private String name;

    //Бренд продукту
    private String brand;

    //Ціна продукту
    private double price;

    //Колір продукту
    private String color;

    //Чи є продукт органічним
    private boolean isOrganic;

    /**
     * Конструктор для ініціалізації косметичного продукту.
     *
     * @param name      назва продукту
     * @param brand     бренд продукту
     * @param price     ціна продукту
     * @param color     колір продукту
     * @param isOrganic чи є продукт органічним
     */
    public Cosmetic(String name, String brand, double price, String color, boolean isOrganic) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.color = color;
        this.isOrganic = isOrganic;
    }

    /**
     * Отримує назву продукту.
     *
     * @return назва продукту
     */
    public String getName() {
        return name;
    }

    /**
     * Встановлює назву продукту.
     *
     * @param name нова назва продукту
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Отримує бренд продукту.
     *
     * @return бренд продукту
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Встановлює бренд продукту.
     *
     * @param brand новий бренд продукту
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Отримує ціну продукту.
     *
     * @return ціна продукту
     */
    public double getPrice() {
        return price;
    }

    /**
     * Встановлює ціну продукту.
     *
     * @param price нова ціна продукту
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Отримує колір продукту.
     *
     * @return колір продукту
     */
    public String getColor() {
        return color;
    }

    /**
     * Встановлює колір продукту.
     *
     * @param color новий колір продукту
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Перевіряє, чи є продукт органічним.
     *
     * @return {@code true}, якщо продукт органічний; {@code false} в іншому випадку
     */
    public boolean isOrganic() {
        return isOrganic;
    }

    /**
     * Встановлює органічність продукту.
     *
     * @param organic новий стан органічності продукту
     */
    public void setOrganic(boolean organic) {
        isOrganic = organic;
    }

    /**
     * Виводить повну інформацію про косметичний продукт.
     */
    public void displayInfo() {
        System.out.println("Cosmetic Product: " + name);
        System.out.println("Brand: " + brand);
        System.out.println("Price: $" + price);
        System.out.println("Color: " + color);
        System.out.println("Organic: " + (isOrganic ? "Yes" : "No"));
    }

    /**
     * Перевіряє еквівалентність поточного продукту іншому об'єкту.
     *
     * @param obj об'єкт для порівняння
     * @return {@code true}, якщо об'єкти еквівалентні; {@code false} в іншому випадку
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cosmetic cosmetic = (Cosmetic) obj;
        return Double.compare(cosmetic.price, price) == 0 &&
                isOrganic == cosmetic.isOrganic &&
                name.equals(cosmetic.name) &&
                brand.equals(cosmetic.brand) &&
                color.equals(cosmetic.color);
    }
}