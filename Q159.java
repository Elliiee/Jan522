import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Q159 {
    /*
    159 Longest Substring with at most two Distinct characters
    Given a string s, return the length of the longest substring that contains
    at most two distinct characters.
    Input: s = "eceba"
    Output: 3
    Explanation: The substring is "ece" which its length is 3.
     */

    //Approach 1 sliding window
    public int lengthOfLongestSubstringTwoDistinct(String s){
        int left = 0, right = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()){
            map.put(s.charAt(right), right);

            if(map.size() > 2){
                int smallestIndex = Collections.min(map.values()); //remember this method
                map.remove(s.charAt(smallestIndex));
                left = smallestIndex + 1;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
