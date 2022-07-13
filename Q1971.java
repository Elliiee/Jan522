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

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        boolean[] seen = new boolean[n];
        Arrays.fill(seen, false);

        while(!queue.isEmpty()){
            int node = queue.poll();

            if (node == destination)
                return true;

            if (seen[node])
                continue;
            seen[node] = true;

            for (int neighbor : adjacencyList.get(node))
                queue.add(neighbor);
        }

        return false;
    }

    public boolean validPathBFS(int n, int[][] edges, int start, int end){
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++){
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        boolean seen[] = new boolean[n];
        Arrays.fill(seen, false);
        seen[start] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();

            if (node == end)
                return true;

            for (int neighbor : adjacencyList.get(node)){
                if (!seen[neighbor]){
                    seen[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}
