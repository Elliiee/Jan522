class QuickUnion {
    private int[] root;

    public QuickUnion(int size){
        root = new int[size];
        for (int i = 0; i < size; i++){
            root[i] = i;
        }
    }

    public int find(int x){
        while (x != root[x]) // 只要自身不是root就一直loop到找到root为止
            x = root[x];
        return x;
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY)
            root[rootY] = rootX;
    }

    public boolean connected(int x, int y){
        return find(x) == find(y);
    }
}
