import java.util.HashSet;
import java.util.Set;

public class Q267 {
    /*
    267 Palindrome Permutation II
    Given a string s, return all the palindromic permutations (without duplicates)
    of it. You may return the answer in any order. If s has no palindromic permutation,
    return an empty list.
     */

    /*
    Approach 1 Brute Force
    1. generate every possible permutation of the given string
    2. and check if the generated permutation is a palindrome
    3. add the palindrome permutations to a set to eliminate the duplicates
    4. return an array comprised of the elements of this set as the result.
     */
    private Set<String> set = new HashSet<>();

    private boolean isPalindrome(char[] s){
        int left = 0, right = s.length - 1;
        while (left < right){
            if (s[left] != s[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    private void permute(char[] s, int len){
        if (len == s.length){
            if (isPalindrome(s)){
                set.add(new String(s)); // change the array to string at the same time
            } else{
                //this step is so confusing ...
                for (int i = 1; i < s.length; i++){
                    swap(s, len, i);
                    permute(s, len + 1);
                    swap(s, len, i);
                }
            }
        }
    }
}
