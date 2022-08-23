public class Q680 {
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length()-1; i < j; i++, j--){
            if (s.charAt(i) != s.charAt(j))
                return isPalindrome(s, i, j-1) || isPalindrome(s, i+1, j);
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right){
        while (left < right){
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}
