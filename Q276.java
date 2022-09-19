import java.util.HashMap;

public class Q276 {
    //Paint Fence
    private HashMap<Integer, Integer> memo = new HashMap<>();

    private int totalWays(int i, int k){
        if (i == 1) return k;
        if (i == 2) return k * k;

        if (memo.containsKey(i))
            return memo.get(i);

        memo.put(i, (k - 1) * (totalWays(i - 1, k) + totalWays(i - 2, k)));

        return memo.get(i);
    }

    public int numWays(int n, int k){
        return totalWays(n, k);
    }

    public int numWaysBottomUp(int n, int k){
        if (n == 1) return k;
        if (n == 2) return k * k;

        int totalWays[] = new int[n + 1];
        totalWays[1] = k;
        totalWays[2] = k * k;

        for (int i = 3; i <= n; i++){
            totalWays[i] = (k - 1) * (totalWays[i - 1] + totalWays[i - 2]);
        }

        return totalWays[n];
    }
}
