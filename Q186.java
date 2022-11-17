public class Q186 {
    /*
    186 Reverse Words ina String II
    Given a character array s, reverse the order of the words.
    A word is defined as a sequence of non-space characters. The words in
    s will be separated by a single space.
    Your code must solve the problem in-place, i.e.without extra space
    Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
    Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
     */

    /*
    Approach 1 reverse the whole String and then reverse each word
     */

    //reverse the whole string
    private void reverseString(char[] s, int left, int right){
        while (left < right){
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    private void reverseEachWord(char[] s){
        int len = s.length;
        int left = 0, right = 0;
        while (left < len){
            while (right < len && s[right] != ' ') {
                right++;
            }
            reverseString(s, left, right - 1);
            left = right + 1;
            right++;
        }
    }

    public void reverseWords(char[] s){
        reverseString(s, 0, s.length - 1);
        reverseEachWord(s);
    }

    //time limited exceeded
}
