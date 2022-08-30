import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q139 {
    private boolean helper(String s, int start, Set<String> wordSet, Boolean[] canBreak){
        if (start == s.length())
            return true;

        if (canBreak[start] != null)
            return canBreak[start];

        boolean res = false;
        for (int i = start + 1; i <= s.length(); i++){
            String currWord = s.substring(start, i);

            if (!wordSet.contains(currWord))
                continue;

            if (helper(s, i, wordSet, canBreak)){
                res = true;
                break;
            }
        }
        canBreak[start] = res;
        return res;
    }

    public boolean wordBreak(String s, List<String> wordDict){
        Boolean[] canBreak = new Boolean[s.length()];
        Set<String> wordSet = new HashSet<>(wordDict);
        return helper(s, 0, wordSet, canBreak);
    }
}
