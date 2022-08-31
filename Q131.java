import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Q131 {
    //Palindrome partitioning
    //分割字符串使得每个部分都是回文数
    private boolean isPalindrome(String s, int begin, int end){
        while (begin < end){
            if (s.charAt(begin++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    private void doPartition(String s, List<String> level, List<List<String>> results){
        if (s.length() == 0){
            results.add(new ArrayList<>(level));
            return;
        }
        for (int i = 0; i < s.length(); i++){
            if (isPalindrome(s, 0, i)){
                level.add(s.substring(0, i + 1));
                doPartition(s.substring(i + 1), level, results);
                level.remove(level.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s){
        List<List<String>> results = new ArrayList<>();
        doPartition(s, new ArrayList<>(), results);
        return results;
    }
}
