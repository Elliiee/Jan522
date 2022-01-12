import java.util.HashMap;

/*
387 First Unique Character in a String
Given a string s, find the first non-repeating character in it and return its index. If it does
not exist, return -1.
 */
public class Q387 {
    public int firstUniqChar(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            if (!map.containsKey(current)){
                map.put(current, i);
            } else {
                // this is not unique, make the index -1
                map.put(current, -1);
            }
        }

        int min = Integer.MAX_VALUE;
        for (char c : map.keySet()){
            if (map.get(c) > -1 && map.get(c) < min){
                min = map.get(c);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
