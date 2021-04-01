import java.util.ArrayList;
import java.util.Arrays;

public class SentenceListing {
    public int[] indexes;
    public int similarityRate;

    public SentenceListing(int[][] matrix) {
        int[] values = new int[matrix[0].length];
        int[] maxValues = new int[matrix.length];


        for (int row = 0; row < matrix.length; row++) {
            int x = 0;
            for (int col = 0; col < matrix[row].length; col++) {
                values[x] = matrix[row][col];
                x++;
            }
            Arrays.sort(values);
            maxValues[row] = values[values.length - 1];
        }

        similarityRate=similarityFinder(maxValues);
        indexes = maxValueMatcher(maxValues);

    }

    public int[] maxValueMatcher(int[] MaxValues) {
        ArrayList<Integer> indexes = new ArrayList<>();
        int[] Indexes;

        for (int j = 0; j < 5; j++) {
            int temp;
            int index = 0;
            temp = MaxValues[0];
            for (int i = 1; i < MaxValues.length; i++) {

                if (MaxValues[i] > temp) {
                    temp = MaxValues[i];
                    index = i;
                }


            }
            MaxValues[index] = -1;

            indexes.add(index);

        }
        Indexes = indexes.stream().mapToInt(i -> i).toArray();
        return Indexes;

    }

    public int similarityFinder(int[] MaxValues) {
        int sum = 0;

        for (int i = 0; i < MaxValues.length; i++) {
            sum = sum + MaxValues[i];
        }
        sum = sum / MaxValues.length;

        return sum;

    }


}
