import java.util.List;

public class Q524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        for (String target : dictionary){
            int l1 = result.length(), l2 = target.length();

            if (l1 > l2 || (l1 == l2 && result.compareTo(target) < 0))
                continue;

            if (isSubstr(s, target))
                result = target;
        }
        return result;
    }

    private boolean isSubstr(String s, String target){
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()){
            if (s.charAt(i) == target.charAt(j))
                j++;
            i++;
        }
        return j == target.length();
    }
}
