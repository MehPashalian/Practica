public class task1 {

        public static void main(String[] args) {
            int[][] matrix = {
                    {1, 0, 3, 0},
                    {0, 0, 0, 0},
                    {5, 0, 7, 0},
                    {0, 0, 0, 0}
            };

            printMatrix(matrix);
            int[][] result = compressMatrix(matrix);
            System.out.println("Уплотненная матрица:");
            printMatrix(result);
        }

        public static int[][] compressMatrix(int[][] matrix) {
            int rowLength = matrix.length;
            int colLength = matrix[0].length;

            int rowsToRemove = 0;
            int colsToRemove = 0;

            // Подсчитываем количество строк и столбцов, заполненных нулями
            for (int i = 0; i < rowLength; i++) {
                boolean isZeroRow = true;
                for (int j = 0; j < colLength; j++) {
                    if (matrix[i][j] != 0) {
                        isZeroRow = false;
                        break;
                    }
                }
                if (isZeroRow) {
                    rowsToRemove++;
                }
            }

            for (int j = 0; j < colLength; j++) {
                boolean isZeroCol = true;
                for (int i = 0; i < rowLength; i++) {
                    if (matrix[i][j] != 0) {
                        isZeroCol = false;
                        break;
                    }
                }
                if (isZeroCol) {
                    colsToRemove++;
                }
            }

            // Создаем новую матрицу с уменьшенными размерами
            int[][] result = new int[rowLength - rowsToRemove][colLength - colsToRemove];
            int rowIndex = 0;
            int colIndex;

            for (int i = 0; i < rowLength; i++) {
                if (rowsToRemove == 0 || !isZeroRow(matrix, i)) {
                    colIndex = 0;
                    for (int j = 0; j < colLength; j++) {
                        if (colsToRemove == 0 || !isZeroCol(matrix, j)) {
                            result[rowIndex][colIndex] = matrix[i][j];
                            colIndex++;
                        }
                    }
                    rowIndex++;
                }
            }

            return result;
        }

        private static boolean isZeroRow(int[][] matrix, int rowIndex) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[rowIndex][j] != 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean isZeroCol(int[][] matrix, int colIndex) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][colIndex] != 0) {
                    return false;
                }
            }
            return true;
        }

        private static void printMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
