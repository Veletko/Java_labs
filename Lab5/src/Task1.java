public class Task1 {
    /*
    * Написать и протестировать методы работы с квадратными матрицами (матрицы представить в виде двухмерных массивов). Должны присутствовать методы:
•	создания единичной (диагональной) матрицы;
•	создания нулевой матрицы;
•	сложение матриц;
•	умножения матриц;
•	умножение матрицы на скаляр;
•	определение детерминанта матрицы;
•	вывод матрицы на консоль.
*/
    // Создание единичной матрицы
    public static double[][] createIdentityMatrix(int size) {
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1.0;
        }
        return matrix;
    }

    // Создание нулевой матрицы
    public static double[][] createZeroMatrix(int size) {
        return new double[size][size]; // По умолчанию массив заполняется нулями
    }

    // Сложение матриц
    public static double[][] add(double[][] a, double[][] b) {
        int size = a.length;
        if (size != b.length) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера");
        }
        double[][] result = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    // Умножение матриц
    public static double[][] multiply(double[][] a, double[][] b) {
        int size = a.length;
        if (size != b.length) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера");
        }
        double[][] result = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    // Умножение матрицы на скаляр
    public static double[][] multiplyByScalar(double[][] matrix, double scalar) {
        int size = matrix.length;
        double[][] result = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }
        return result;
    }

    // Вычисление определителя
    public static double determinant(double[][] matrix) {
        int size = matrix.length;
        if (size == 1) {
            return matrix[0][0];
        }
        if (size == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double det = 0;
        for (int i = 0; i < size; i++) {
            det += matrix[0][i] * cofactor(matrix, 0, i);
        }
        return det;
    }

    // Вычисление алгебраического дополнения
    private static double cofactor(double[][] matrix, int row, int col) {
        return Math.pow(-1, row + col) * determinant(getMinor(matrix, row, col));
    }

    // Получение минора матрицы
    private static double[][] getMinor(double[][] matrix, int row, int col) {
        int size = matrix.length;
        double[][] minor = new double[size - 1][size - 1];
        int mRow = 0;
        for (int i = 0; i < size; i++) {
            if (i == row) continue;
            int mCol = 0;
            for (int j = 0; j < size; j++) {
                if (j == col) continue;
                minor[mRow][mCol] = matrix[i][j];
                mCol++;
            }
            mRow++;
        }
        return minor;
    }

    // Вывод матрицы на консоль
    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%8.2f", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // Тестирование методов
    public static void main(String[] args) {
        // Тест 1: Единичная матрица
        System.out.println("Единичная матрица 3x3:");
        double[][] identity = createIdentityMatrix(3);
        printMatrix(identity);

        // Тест 2: Нулевая матрица
        System.out.println("Нулевая матрица 3x3:");
        double[][] zero = createZeroMatrix(3);
        printMatrix(zero);

        // Тест 3: Сложение матриц
        System.out.println("Сложение матриц:");
        double[][] m1 = {{1, 2}, {3, 4}};
        double[][] m2 = {{5, 6}, {7, 8}};
        System.out.println("Матрица 1:");
        printMatrix(m1);
        System.out.println("Матрица 2:");
        printMatrix(m2);
        System.out.println("Сумма:");
        printMatrix(add(m1, m2));

        // Тест 4: Умножение матриц
        System.out.println("Умножение матриц:");
        printMatrix(multiply(m1, m2));

        // Тест 5: Умножение на скаляр
        System.out.println("Умножение матрицы на скаляр (2):");
        printMatrix(multiplyByScalar(m1, 2));

        // Тест 6: Определитель
        System.out.println("Определитель матрицы 1:");
        System.out.println(determinant(m1));
    }
}