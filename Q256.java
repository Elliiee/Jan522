import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q256 {
    /*
    256 Paint House
    There is a row of n houses, where each house can be painted one of 3 colors: red,
    blue, or green. The cost of painting each house with a certain color is different.
    You have to paint all the houses such that no two adjacent houses have the same color.
    The cost of painting each house with a certain color is represented by an n x 3 cost
    matrix costs.
     */

    /*
    Approach 2 brute force with a recursive tree
    When we have permutations, we can think of them as forming a big tree of options.
    Calculate the cost of each choice
     */
    private int[][] costs;

    public int minCostII(int[][] costs){
        if (costs.length == 0) return 0;

        this.costs = costs;

        return Math.min(paintCost(0, 0),
                Math.min(paintCost(0, 1), paintCost(0, 2)));
    }

    private int paintCost(int n, int color){
        int totalCost = costs[n][color];

        if (n == costs.length - 1){

        } else if (color == 0){ //red
            totalCost += Math.min(paintCost(n + 1, 1), paintCost(n + 1, 2));
        } else if (color == 1){ //green
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 2));
        } else { //blue
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 1));
        }
        return totalCost;
    }

    /*
    Approach 3: Memoization
     */
    private Map<String, Integer> memo;


}
