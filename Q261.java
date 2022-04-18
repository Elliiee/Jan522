public class Q261 {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges){
            int X = edge[0];
            int Y = edge[1];
            if (!uf.union(X, Y))
                return false;
        }

        return true;
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

        boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return false;
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
            return true;
        }

        int getCount(){
            return count;
        }
    }
}
