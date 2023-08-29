public class UnionFind {
    private int[] parent;
    private int[] rank;
    private int count;

    public UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        count = n;

        for (int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    //iterative way of writing find function with path compression
    public int find(int x){
        int root = x;

        //find the root
        while (root != parent[root]){
            root = parent[root];
        }

        //change the root value for the nodes all the way up
        while (x != root){
            int oldRoot = parent[x];
            parent[x] = root;
            x = oldRoot;
        }
        return root; // return the root value;
    }

    public boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY){
            return false; //nodes in the say component no need to union
        }

        if (rank[rootX] < rank[rootY]){
            root[rootX] = rootY; // attach the low rank to the high rank
            count--;
        } else if (rank[rootX] > rank[rootY]){
            root[rootY] = rootX;
            count--;
        } else {
            //the same rank, choose either one to attach
            root[rootY] rootX;
            rank[rootX]++; //increase the rank
            count--;
        }
    }

    public int getCount(){
        return count;
    }
}
