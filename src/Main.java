
import java.io.IOException;
import java.util.Arrays;


public class Main {


    public static void main(String[] args) throws IOException {
        String document = "document";
        for (int i = 0; i < 5; i++) {
            String doc = document + (i + 1) + ".txt";
            System.out.print("Similarity rate with " + (i + 1) + ". document: % ");
            secondaryMain(doc);
        }
    }

    public static void secondaryMain(String subTextPath) throws IOException {
        FileGenerator mainFile = new FileGenerator(System.getProperty("user.dir") + "/main_doc.txt");
        FileGenerator subFile = new FileGenerator(subTextPath);
        MatrixGenerator MG = new MatrixGenerator(mainFile.mainText, subFile.subText);
        Proportioner proportioner = new Proportioner();
        MG.comparisonMatrix = proportioner.findRate(subFile.wordCount, MG.comparisonMatrix);

        SentenceListing topFiveSentences = new SentenceListing(MG.comparisonMatrix);

        System.out.println(topFiveSentences.similarityRate);
        for (int i = 0; i < 5; i++) {
            String replace;
            replace = Arrays.toString(subFile.fullSubText.get(topFiveSentences.indexes[i])).replaceAll("\\]", "");
            replace = replace.replaceAll("\\[", "");
            replace = replace.replaceAll(",", "");
            System.out.println((i + 1) + ". Most Similar Sentence: " + replace);
        }
    }
}
