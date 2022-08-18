import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        // COUNT NUMBER OF WORDS TRANSFORMED
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // FOR ALL WORDS THIS ROUND
            for (int i = 0; i < size; i++) {
                char[] current = queue.poll().toCharArray();
                // TRAVERSE CURRENT WORD
                for (int j = 0; j < current.length; j++) {
                    char tmp = current[j];
                    // CHANGE ONE LETTER AT A TIME
                    for (char c = 'a'; c <= 'z'; c++) {
                        current[j] = c;
                        String next = new String(current);
                        // WHEN NEXT WORD IS IN THE SET
                        if (set.contains(next)) {
                            if (next.equals(endWord)) return count + 1;
                            queue.add(next);
                            set.remove(next);
                        }
                    }
                    // HAVE TO UNDO FOR NEXT CHANGE OF LETTER
                    current[j] = tmp;
                }
            }
            // THIS ROUND ENDS WITH ONE LETTER CHANGED
            count++;
        }
        return 0;
    }

    private List<Integer>[] buildGraph(List<String> wordList){
        int size = wordList.size();
        List<Integer>[] result = new List[size];
        for (int i = 0; i < size; i++){
            result[i] = new ArrayList<>();
            for (int j = 0; j < size; j++){
                if (isConnected(wordList.get(i), wordList.get(j)))
                    result[i].add(j);
            }
        }
        return result;
    }

    private boolean isConnected(String s1, String s2){
        int diffCount = 0;
        for (int i = 0; i < s1.length() && diffCount <= 1; i++){
            if (s1.charAt(i) != s2.charAt(i))
                diffCount++;
        }
        return diffCount == 1;
    }

    private int getShortestPath(List<Integer>[] graph, int start, int end){
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];
        queue.add(start);
        visited[start] = true;
        int path = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            path++;
            for (int i = 0; i < size; i++){
                int current = queue.poll();
                for (int next : graph[current]){
                    if (next == end) return path;

                    if(visited[next]) continue;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }

    public int ladderLengthII(String beginWord, String endWord, List<String> wordList){
        wordList.add(beginWord);
        int size = wordList.size();
        int start = size - 1;
        int end = 0;
        while(end < size && !wordList.get(end).equals(endWord)){
            end++;
        }
        if (end == size) return 0;

        List<Integer>[] graph = buildGraph(wordList);

        return getShortestPath(graph, start, end);
    }
}
