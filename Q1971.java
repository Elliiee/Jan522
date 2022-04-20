import java.util.*;

public class Q1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination){
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++){
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(source);

        boolean[] seen = new boolean[n];
        Arrays.fill(seen, false);

        while(!stack.isEmpty()){
            int node = stack.pop();

            if (node == destination)
                return true;

            if (seen[node])
                continue;
            seen[node] = true;

            for (int neighbor : adjacencyList.get(node))
                stack.push(neighbor);
        }

        return false;
    }
}
