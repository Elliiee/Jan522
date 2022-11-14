import java.util.*;

public class Q140 {
    /*
    140 word break II
     */
    public List<String> wordBreak(String s, Set<String> wordDict){
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map){
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String> res = new LinkedList<>();

        if (s.length() == 0){
            res.add("");
            return res;
        }

        for (String word : wordDict){
            if (s.startsWith(word)){
                List<String> subList = DFS(s.substring(word.length()), wordDict, map);

                for (String sub : subList)
                    res.add(word + (sub.isEmpty() ? "" : "") + sub);
            }
        }

        map.put(s, res);
        return res;
    }

    //use memo to prune, reduce duplicate computations
    HashMap<String, List<String>> map = new HashMap<>();

    public List<String> wordBreakII(String s, Set<String> wordDict){
        List<String> res = new ArrayList<>();

        if (s == null || s.length() == 0)
            return res;

        //check if the current input string has been computed before
        if (map.containsKey(s))
            return map.get(s);

        //if the input itself is a valid word that exists in wordDict, we add it to the current
        if (wordDict.contains(s))
            res.add(s);

        for (int i = 1; i < s.length(); i++){
            //loop through the string to find the first valid postfix
            String t = s.substring(i);

            //if we've found one
            if (wordDict.contains(t)){
                List<String> temp = wordBreakII(s.substring(0, i), wordDict);
                if (temp.size() != 0){
                    for (int j = 0; j < temp.size(); j++)
                        res.add(temp.get(j) + " " + t);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
