import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q547 {
    /*
    Update more on 04/26/23 Wed
     */
    Map<Integer, List<Integer>> graph = new HashMap<>();
    boolean[] seen;

    private void dfs(int node){
        for (int neighbor : graph.get(node)){
            if (!seen[neighbor]){
                seen[neighbor] = true; //mark as visited
                dfs(neighbor); //keep going dfs to the neighbor
            }
        }
    }

    public int findCircleNum(int[][] isConnected){
        int n = isConnected.length;

        for (int i = 0; i < n; i++){
            graph.putIfAbsent(i, new ArrayList<>());

            for (int j = i + 1; j < n; j++){
                graph.putIfAbsent(j, new ArrayList<>());

                if (isConnected[i][j] == 1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        seen = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++){
            if (!seen[i]){
                ans++;
                seen[i] = true;
                dfs(i);
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[][] isConnected = {{1,1,0}, {1,1,0},{0,0,1}};
    }

    class UnionFind{
        private int[] root;
        private int[] rank;
        private int count;

        UnionFind(int size){
            root = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++){
                root[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x){
            if (x == root[x])
                return x;
            return root[x] = find(root[x]);
        }

        void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY){
                if (rank[rootX] > rank[rootY]){
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]){
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                count--;
            }
        }

        int getCount(){
            return count;
        }
    }
}
