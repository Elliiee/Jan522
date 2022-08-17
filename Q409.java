import java.util.HashSet;

public class Q409 {
    //Longest palindrome
    public int longestPalindrome(String s){
        if (s == null || s.length() == 0) return 0;

        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
                count++;
            } else {
                set.add(s.charAt(i));
            }
        }

        if (!set.isEmpty())
            return count*2 + 1; // you can add one/make it longer in the middle it's still a palindrome

        return count*2;
    }
}
