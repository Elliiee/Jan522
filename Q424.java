public class Q424 {
    /*
    You are given a string s and an integer k. You can choose any character of the string
    and change it to any other uppercase English character. You can perform this operation
    at most k times.
    Return the length of the longest substring containing the same letter you can get after
    performing the above operations.
     */

    /*
    Using the sliding window technique, we set up pointers left = 0 and right = 0.
    We know that our current window/ substring is valid when the number of characters
    that need to be replaced is <= k.

    We need to know how many letters in our substring that we need to replace.
    lettersToReplace = (end - start + 1) -mostFreqLetter;
    Pretty much you take the size of the window minus the most frequent letter that is
    in the current window.

    Now that we know how many characters that need to be replaced in our window, we
    can deduce that if lettersToReplace > k than the window is invalid then we decrease
    the window size from the left;
     */

    public int characterReplacement(String s, int k){
        int[] freq = new int[26];
        int mostFreqLetter = 0;
        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++){
            freq[s.charAt(right) - 'A']++;

            mostFreqLetter= Math.max(mostFreqLetter, freq[s.charAt(right) - 'A']);

            int lettersToChange = (right - left + 1) - mostFreqLetter;
            if (lettersToChange > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
