import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q279 {
    //perfect squares
    public int numSquares(int n){
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            while (size-- > 0){
                int current = queue.poll();
                for (int s : squares){
                    int next = current - s;
                    if (next < 0)
                        break;
                    if (next == 0)
                        return level;
                    if (marked[next])
                        continue;
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return n;
    }

    private List<Integer> generateSquares(int n){
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;

        while(square <= n){
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }
}
