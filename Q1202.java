import java.util.*;

public class Q1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());

        for (List<Integer> edge : pairs){
            int X = edge.get(0);
            int Y = edge.get(1);

            uf.union(X, Y);
        }

        Map<Integer, List<Integer>> rootToComponent = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            int rootIndex = uf.find(i);
            rootToComponent.putIfAbsent(rootIndex, new ArrayList<>());
            rootToComponent.get(rootIndex).add(i);
        }

        char[] smallestS = new char[s.length()];
        for(List<Integer> indices : rootToComponent.values()){
            List<Character> characters = new ArrayList<>();
            for (int index : indices){
                characters.add(s.charAt(index));
            }
            Collections.sort(characters);

            for (int index = 0; index < indices.size(); index++){
                smallestS[indices.get(index)] = characters.get(index);
            }
        }

        return new String(smallestS);
    }

    class UnionFind {
        private int[] root;
        private int[] rank;
        private int count;

        UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (x == root[x])
                return x;
            return root[x] = find(root[x]);
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                count--;
            }
        }

        int getCount() {
            return count;
        }
    }
}
