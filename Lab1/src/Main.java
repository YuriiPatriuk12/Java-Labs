/**
 * Головний клас програми, який демонструє роботу з класом MatrixManager.
 * Виконує створення матриці, транспонування, виведення матриць на консоль 
 * та обчислення результату для 2 завдання.
 */
public class Main {

    /**
     * Точка входу в програму.
     * Демонструє роботу з методами класу MatrixManager, включаючи:
     * - Виведення початкової матриці;
     * - Транспонування матриці;
     * - Виведення транспонованої матриці;
     * - Обчислення результату для 2 завдання з транспонованої матриці.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        // Створення об'єкта класу MatrixManager для роботи з матрицями
        MatrixManager manager = new MatrixManager();

        // Початкова матриця
        short[][] matrix = new short[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        };

        // Виведення початкової матриці
        manager.printMatrix(matrix);

        // Транспонування матриці
        var resMatrix = manager.matrixTransposition(matrix);

        // Виведення транспонованої матриці
        manager.printMatrix(resMatrix);

        // Обчислення і виведення результату другого завдання
        System.out.println(manager.calculateSecondTask(resMatrix));
    }
}
