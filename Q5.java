public class Q5 {
    /*
    Find the longest palindrome

    Similar to 647
     */
    private int lo, maxLen; //lo is used to track the start index of the answer

    public String longestPalindrome(String s){
        int len = s.length();

        if (len < 2) return s;

        //similar to 647
        for (int i = 0; i < len - 1; i++){
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(lo, lo + maxLen); // here add maxLen to the start index
        //so in the private method maxLen - 1 from j - i; maxLen = j - i - 1;
    }

    private void extendPalindrome(String s, int i, int j){
        //extend the palindrome from the center, similar to 647
        while (i >= 0 && j < s.length() && (s.charAt(i) == s.charAt(j))){
            i--;
            j++;
        }

        if (maxLen < j - i - 1){
            maxLen = j - i - 1; //check if the current palindrome length is the longest;
            lo = i + 1; //the start index of the next search;
        }
    }
}
