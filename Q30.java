import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q30 {
    /*
    30 substring with concatenation of all words
    You are given a string s and an array of strings words. All the strings of words
    are of the same length.
    A concatenated substring in s is a substring that contains all the strings of any
    permutation of words concatenated.
    Return the starting indices of all the concatenated substrings in s, in any order.
     */

    /*
    Approach 1 check all indices using a hash table
    An important detail in the problem description to notice is that all elements in
    words have the same length. This gives us valuable information about all valid
    substrings -- we know the length of the answer:
    words.length * words[0].length();
     */
    private HashMap<String, Integer> wordCount = new HashMap<>(); //map
    private int wordLength; //length of each word in words
    private int substringSize; //wordLength * k
    private int k; //length of words

    //i -- the start index;
    // returns if a valid answer starts at index i
    private boolean check(int i, String s){
        //copy of the hashmap wordCount
        HashMap<String, Integer> remaining = new HashMap<>(wordCount);
        int wordsUsed = 0;

        //starts from i, and we don't need to go further than substringSize
        //we know each word has a length of wordLength, so increase each time
        for (int j = i; j < i + substringSize; j += wordLength){
            String sub = s.substring(j, j + wordLength);
            if (remaining.getOrDefault(sub, 0) != 0){
                remaining.put(sub, remaining.get(sub) - 1);
                wordsUsed++;
            } else {
                break;
            }
        }

        // wordsUsed == k means we used up all the words in words
        return wordsUsed == k;
    }

    public List<Integer> findSubstring(String s, String[] words){
        int n = s.length();
        k = words.length;
        wordLength = words[0].length();
        substringSize = wordLength * k;

        for (String word : words){
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        List<Integer> answer = new ArrayList<>();
        //we can check all possible starting indices
        //because a valid substring has a length of substringSize, we only need to
        //iterate up to n - substringSize
        for (int i = 0; i < n - substringSize + 1; i++){
            if (check(i, s)){
                answer.add(i);
            }
        }

        return answer;
    }


    /*
    Approach 2 Sliding Window
    We can re-use most of the logic from the previous approach, but this time instead of
    only checking for one valid substring at a time with each cal to check, we will try
    to find all valid substrings in one pass by sliding our window across s.
     */
}
