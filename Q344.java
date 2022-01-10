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
}
