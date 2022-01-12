import java.util.Arrays;

/*
242 valid Anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
public class Q242 {
    public boolean isAnagram(String s, String t){
        if (s.length() != t.length())
            return false;

        char[] str1 = s.toCharArray();
        char[] str2 = s.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
