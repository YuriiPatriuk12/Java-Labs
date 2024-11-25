package SaladAndComponents;

public abstract class Vegetable {
    private double weight;
    private double caloriesPer100Gram;
    private String variety;

    protected Vegetable() {
        caloriesPer100Gram = 0;
    }

    protected Vegetable(double weight, double caloriesPer100Gram, String variety) {
        this.weight = weight;
        this.caloriesPer100Gram = caloriesPer100Gram;
        this.variety = variety;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCalories() {
        return caloriesPer100Gram;
    }

    public void setCalories(double calories) {
        this.caloriesPer100Gram = calories;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public double calculateTotalCalories() {
        return (caloriesPer100Gram * weight) / 100;
    }

    @Override
    public String toString() {
        return String.format("%s\nWeight: %.2f \nCalories per 100 grams: %.2f \nTotal calories: %.2f \nVariety: %s",
                getClass().getSimpleName(), weight, caloriesPer100Gram, calculateTotalCalories(), variety);
    }
}
