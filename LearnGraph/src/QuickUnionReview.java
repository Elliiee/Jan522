public class QuickUnionReview {
    private int[] root;

    public QuickUnionReview(int size){
        for (int i = 0; i < size; i++){
            root[i] = i;
        }
    }

    public int find(int x){
        while(root[x] != x){
            x = root[x];
        }
        return root[x];
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY){
            root[rootY] = rootX;
        }
    }

    public boolean connected(int x, int y){
        return find(x) == find(y);
    }
}
