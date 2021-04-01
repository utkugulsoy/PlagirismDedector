import java.util.Arrays;
import java.util.Objects;


public class SentenceShredder {
    public String[] words;


    public SentenceShredder(String Sentence) {

        words = Sentence.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("\\p{Punct}", "");//Delete all punctuation.

        }
        words = duplicateRemover(words);


    }

    public SentenceShredder() {

    }

    public String[] duplicateRemover(String[] param) {
        for (int i = 0; i < param.length; i++) {
            for (int j = i + 1; j < param.length; j++) {
                if (param[i].equals(param[j])) {
                    param[j] = "";
                }
            }
        }
        for (int i = 0; i < param.length; i++) {
            if (param[i].equals("")) {
                param[i] = null;
            }
        }
        return Arrays.stream(param).filter(Objects::nonNull).toArray(String[]::new);
    }


    public void subSentenceShredder(String Sentence) {
        words = Sentence.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("\\p{Punct}", "");//Delete all punctuation.

        }


    }


}
