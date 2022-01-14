import java.util.Locale;

/*
125 Valid Palindrome
A phrase is a palindrome if, after converting all uppercase letters into lowercase
letters and removing all non-alphanumeric characters, it reads the same forward and
backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class Q125 {
    public boolean isPalindrome(String s){
        String result = "";

        for (char c : s.toCharArray()){
            if (Character.isDigit(c) || Character.isLetter(c)){
                result += c;
            }
        }
        result = result.toLowerCase();

        int a = 0;
        int b = result.length() - 1;

        while (a <= b){
            if (result.charAt(a) != result.charAt(b))
                return false;
            a++;
            b--;
        }
        return true;
    }
}
