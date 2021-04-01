import java.util.ArrayList;

public class MatrixGenerator {
    public int[][] comparisonMatrix;
    public String[] subCompare;
    public String[] mainCompare;
    int counter;

    MatrixGenerator(ArrayList<String[]> main, ArrayList<String[]> sub) {
        comparisonMatrix = new int[sub.size()][main.size()];
        for (int i = 0; i < sub.size(); i++) {
            subCompare = sub.get(i);

            for (int j = 0; j < main.size(); j++) {
                mainCompare = main.get(j);

                for (int z = 0; z < mainCompare.length; z++) {
                    for (int k = 0; k < subCompare.length; k++) {
                        if (subCompare[k].equals(mainCompare[z])) {
                            counter++;
                        }
                    }
                }


                comparisonMatrix[i][j] = counter;

                counter = 0;
            }

        }


    }
}