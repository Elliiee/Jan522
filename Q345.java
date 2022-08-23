import java.util.Arrays;
import java.util.HashSet;

public class Q345 {
    //reverse vowels of a String
    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i',
            'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s){
        if (s == null) return null;

        int left = 0, right = s.length() - 1;
        char[] result = new char[s.length()];
        while (left <= right){
            char l = s.charAt(left);
            char r = s.charAt(right);

            if (!vowels.contains(l))
                result[left++] = l;
            else if (!vowels.contains(r))
                result[right--] = r;
            else{
                result[left++] = r; // switch
                result[right--] = l; // switch
            }
        }
        return new String(result);
    }
}
