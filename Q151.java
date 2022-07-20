import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q151 {
    // reverse words in a string
    public String reverseWords(String s){
        s = s.trim(); // remove leading space
        // split by multiple spaces
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
