public class Q746 {
    //Min cost climbing stairs
    public int minCostClimbingStairs(int[] cost){
        //the array's length should 1 longer than the cost because we
        // can treat the top floor as a step to reach
        int[] minCost = new int[cost.length + 1];

        // start the iteration from step 2, since the min cost of
        // reaching step 0 and 1 are both 0
        for (int i = 2; i < minCost.length; i++){
            int oneStep = minCost[i - 1] + cost[i - 1];
            int twoStep = minCost[i - 2] + cost[i - 2];
            minCost[i] = Math.min(oneStep, twoStep);
        }

        return minCost[minCost.length - 1];
    }
}
