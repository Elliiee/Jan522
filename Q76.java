public class Q76 {
    /*
    76 Minimum window substring
    Given two strings s and t of lengths m and n respectively, return the minimum
    window substring of s such that every character in i (including duplicates) is
    included in the window. If there is no such substring, return the empty string "".
     */

    /*
    For most substring problem, we are given a string and need to find a substring of it
    which satisfy some restrictions.

    A general way is to use a hashmap (an array in java) assisted with two pointers.

    One thing needs to be mentioned is that when asked to find maximum substring, we
    should update maximum after the inner while loop to guarantee that the substring
    is valid. On the other hand, when asked to find minimum substring, we should
    update minimum inside the inner while loop. !!!!
     */

    public String minWindow(String s, String t){
        //we use this to store the counts of the characters in string t.
        int[] map = new int[128];

        for (char c : t.toCharArray()){
            map[c]++; //c is a character, so put the character in
            //it will default to be the index value
        }

        int start = 0, end = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int counter = t.length();//counter is the number of characters in t to be found in s

        //loop though end
        while (end < s.length()){
            final char c1 = s.charAt(end);

            //if character in s exists in t, decrease the counter;
            if (map[c1] > 0){
                counter--;
            }

            map[c1]--;//decrease array element for each char in s, negative if non-exist in t
            end++; //move 1 step right

            while (counter == 0){ // when we found a valid window
                if (minLen > end - start){
                    minLen = end - start;
                    minStart = start;
                }

                final char c2 = s.charAt(start);
                map[c2]++;

                //when char exists in t, increase counter
                if (map[c2] > 0){
                    counter++;
                }

                start++; // move start 1 step right to find if there is smaller answer
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
