public class Proportioner {

    public int[][] findRate(int[] wordCount, int[][] compareMatrix) {
        for (int row = 0; row < compareMatrix.length; row++) {
            for (int col = 0; col < compareMatrix[row].length; col++) {
                compareMatrix[row][col] = (compareMatrix[row][col] * 100) / wordCount[row];
            }

        }
        return compareMatrix;
    }
}
