import java.util.Stack;

public class Q32 {
    /*
    32. Longest Valid Parentheses
    Given a string containing just the characters ( and ), return the length of the
    longest valid parentheses' substring.
     */

    /*
    Approach 1 Brute Force
    Everytime we encounter a ( we push it to the stack. Every time encountered ), we pop
    a ( from the stack.
        If ( isn't available on the stack for popping at anytime or if stack contains
        some elements after processing complete substring, the substring is invalid.
    Repeat the process for every possible substring and store the length of the longest.
     */
    private boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == ')'){
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    public int longestValidParentheses(String s){
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++){
            for (int j = i + 2; j <= s.length(); j += 2){
                if (isValid(s.substring(i, j))){
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
        return maxLen;
    }

    /*
    Approach 2 using DP

     */


}
