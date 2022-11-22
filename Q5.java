public class Q5 {
    //Given a string s, return the longest palindromic substring.
    private int lo, maxLen;

    public String longestPalindrome(String s){
        int len = s.length();

        //If 0 or 1 char, return the input string,
        //no palindrome to be checked for
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++){
            //odd length
            extendPalindrome(s, i, i);
            //even length
            extendPalindrome(s, i, i+1);
        }

        //return the part of the input string starting at the lo index,
        //length of maxLen
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int i, int j){
        //Check if the chars at indexes i and j are the same
        //While we have a palindrome, extend the length of the string:
        //by decreasing the value of the beginning char index i
        // and increasing the value the ending char index j;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }

        //If the length of the current palindrome (j-i-1) is greater than the
        //previous longest palindrome, store the beginning index of the palindrome
        //and the length of the current palindrome.
        if (maxLen < j - i - 1){
            lo = j + 1; //store the beginning index of the palindrome
            maxLen = j - i - 1; //and the length of the current palindrome
        }
    }


    /*

     */

}
