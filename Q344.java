/*
344 Reverse String
Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class Q344 {
    public void reverseString(char[] s){
        int a = 0;
        int b = s.length - 1;
        char temp;
        while (a <= b){
            temp = s[a];
            s[a] = s[b];
            s[b] = temp;
            a++;
            b--;
        }
    }

    public void reverseStringRecursion(char[] s){
        helper(0, s.length - 1, s);
    }

    void helper(int start, int end, char[] s){
        if (start >= end)
            return;

        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        helper(start + 1, end - 1, s);
    }
}
