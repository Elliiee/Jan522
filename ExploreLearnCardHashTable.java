import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExploreLearnCardHashTable {
    /*
    249. Group Shifted Strings
     */
    private String getKey(String s){
        char[] chars = s.toCharArray();
        String key = "";
        for (int i = 1; i < chars.length; i++){
            int diff = chars[i] - chars[i - 1];
            key += diff < 0 ? diff + 26 : diff;
            key += ",";
        }
        return key;
    }

    public List<List<String>> groupStrings(String[] strings){
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings){
            String key = getKey(s);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
