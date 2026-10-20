import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WordHyphenFormatter {

    public static List<String> formatWords(String[] words, int maxLimit) {
        List<String> currentLine = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        int currentLength = 0;

        for (String word : words) {

            int addLen = currentLine.isEmpty() ? word.length() : word.length() + 1;
            if (addLen + currentLength <= maxLimit) {
                currentLine.add(word);
                currentLength += addLen;
            } else {
                lines.add(String.join("-", currentLine));
                currentLine.clear();
                currentLine.add(word);
                currentLength = word.length();

            }

            if (!currentLine.isEmpty()) {
                lines.add(String.join("-", currentLine));
            }
        }
        
        return lines;
    }
}