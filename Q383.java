import java.util.HashMap;

public class Q383 {
    // ransom node
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] mag = magazine.toCharArray();
        for (char c : mag){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char[] ransom = ransomNote.toCharArray();
        for (char c : ransom){
            if (map.containsKey(c)){
                if (map.get(c) == 0)
                    return false;
                else
                    map.put(c, map.get(c) - 1);
            }
            else {
                return false;
            }
        }
        return true;
    }
}
