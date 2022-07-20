public class Q557 {
    //Reverse Words in a String III
    public String reverseWords(String s){
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String w : words){
            result.append(new StringBuffer(w).reverse().toString() + " ");
        }
        return result.toString().trim();
    }
}
