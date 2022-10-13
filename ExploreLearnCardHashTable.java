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

    /*
    170. Two Sum III -- Data Structure Design
     */
    private HashMap<Integer, Integer> map =  new HashMap<>();

    public void add(int number){
        map.put(number, map.getOrDefault(number, 0) + 1);
    }



    /*
    454 4Sum II
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1){
            for (int num2 : nums2){
                map.put(num1 + num2, map.getOrDefault(num1 + num2, 0) + 1);
            }
        }
        for (int num3 : nums3){
            for (int num4 : nums4){
                count += map.getOrDefault(-(num3 + num4), 0);
            }
        }
        return count;
    }
}
