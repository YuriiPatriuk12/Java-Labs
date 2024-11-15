/**
 * Клас, що містить методи для роботи з матрицями.
 * Він дозволяє транспонувати матрицю, обчислити суму
 * найбільших елементів в рядках матриці з непарними номерами та
 * найменших елементів у рядках з парними номерами, а також
 * вивести матриці у консоль.
 */
public class MatrixManager {

    /**
     * Транспонує задану матрицю.
     *
     * @param inputMatrix матриця, яку потрібно транспонувати
     * @return нова транспонована матриця
     */
    public short[][] matrixTransposition(short[][] inputMatrix)
    {
        short[][] result = new short[inputMatrix[0].length][inputMatrix.length];

        for (int i = 0; i < inputMatrix.length; i++)
        {
            for(int j = 0; j < inputMatrix[i].length; j++)
            {
                result[j][i] = inputMatrix[i][j];
            }
        }

        return result;
    }

    /**
     * Обчислює суму найбільших елементів в рядках матриці
     * з непарними номерами та найменших елементів у рядках
     * з парними номерами
     *
     * @param inputMatrix матриця, на основі якої буде виконано обчислення
     * @return сума значень
     */
    public short calculateSecondTask(short[][] inputMatrix)
    {
        short max, min, result = 0;

        for (int i = 0; i < inputMatrix.length; i++)
        {
            if(i % 2 == 0)
            {
                min = inputMatrix[i][0];
                for(int j = 1; j < inputMatrix[i].length; j++)
                {
                    if(inputMatrix[i][j] < min)
                        min = inputMatrix[i][j];
                }
                result += min;
            }
            else
            {
                max = inputMatrix[i][0];
                for(int j = 1; j < inputMatrix[i].length; j++)
                {
                    if(inputMatrix[i][j] > max)
                        max = inputMatrix[i][j];
                }
                result += max;
            }
        }
        return result;
    }

    /**
     * Виводить матрицю на консоль.
     * Кожен елемент матриці виводиться в одному рядку з пробілами між елементами та
     * після виведення рядка переходить на новий.
     *
     * @param inputMatrix матриця, яку потрібно вивести у консоль
     */
    public void printMatrix(short[][] inputMatrix)
    {
        for(short[] row : inputMatrix)
        {
            for(short elem : row)
                System.out.print(elem + " ");
            System.out.println();
        }
        System.out.println();
    }
}
