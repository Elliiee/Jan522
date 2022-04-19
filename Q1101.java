import java.util.Arrays;
import java.util.Comparator;

public class Q1101 {
    public int earliestAcq(int[][] logs, int n){
        if(logs == null || n == 0)
            return -1;

        Arrays.sort(logs, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        UnionFind uf = new UnionFind(n);
        for (int[] log : logs){
            int timestamp = log[0];
            int friendA = log[1];
            int friendB = log[2];
            uf.union(friendA, friendB);

            if (uf.getCount() == 1)
                return timestamp;
        }

        return -1;
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
