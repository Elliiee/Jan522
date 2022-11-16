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

    /*
    131 Palindrome Partitioning
    Given a string s, partition s such that every substring of the partition
    is a palindrome. Return all possible palindrome
    Input: s = "aab"
    Output: [["a","a","b"],["aa","b"]]
     */

    /*
    Overview
    The aim to partition the string into all possible palindrome combinations. To
    achieve this, we must generate all possible substrings of a string by partitioning
    at every index until we reach the end of the string.
    Example, abba can be partitioned as ["a","ab","abb","abba"].
    Each generated substring is considered as a potential candidate.
    Then check if it is a Palindrome.
     */

    /*
    Approach 1 Backtracking
     */

    private void backtracking(int start, List<List<String>> result, List<String> currentList,
                              String s){
        if (start >= s.length()){
            result.add(new ArrayList<String>(currentList));
        }

        for (int end = start; end < s.length(); end++){
            if(isPalindrome(s, start, end)){
                currentList.add(s.substring(start, end + 1));
                backtracking(end + 1, result, currentList, s);
                currentList.remove(currentList.size() - 1);
            }
        }
    }


}
