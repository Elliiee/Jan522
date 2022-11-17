public class Q161 {
    /*
    161 One Edit Distance
    Given two strings s and t, return true if they are both one edit distance
    apart, otherwise return false. Insert, delete, or replace 1 character.
     */
    public boolean isOneEditDistance(String s, String t){
        int sLen = s.length();
        int tLen = s.length();

        //this step is because the following steps are assuming
        //s is the shorted one
        //so if s is the larger one, then reverse them
        if (tLen > s.length()){
            return isOneEditDistance(t, s);
        }

        if (tLen - sLen > 1){
            return false;
        }

        for (int i = 0; i < sLen; i++){
            if(s.charAt(i) != t.charAt(i)){
                if(sLen == tLen){
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    s.substring(i).equals(t.substring(i + 1));
                }
            }
        }

        //when it comes to this step, means: if there is no differences on sLen distance
        //the strings are one edit away only if t has one more character.
        return (sLen + 1 == tLen);
    }
}
