import java.util.*;

public class Q1168 {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes){
        PriorityQueue<int[]> edgesHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        //adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++){ //I think the +1 is because of the fake node
            graph.add(new ArrayList<>());
        }

        //add a fake node and create connection with the real node
        //make the weight of the connection as the cost of building this well/node
        for (int i = 0; i < wells.length; i++){
            int[] virtualEdge = new int[]{wells[i], i + 1}; //{cost of well, neighbor}
            graph.get(0).add(virtualEdge); //add the connections to the adjacency list
            edgesHeap.add(virtualEdge); //add this to the heap
        }

        //create the adjacency list bidirectional edges
        for (int i = 0; i < pipes.length; i++){
            int house1 = pipes[i][0];
            int house2 = pipes[i][1];
            int cost = pipes[i][2];
            graph.get(house1).add(new int[]{cost, house2});
            graph.get(house2).add(new int[]{cost, house1});
        }

        //start from the fake node and explore
        Set<Integer> set = new HashSet<>();
        set.add(0); //mark as visited
        int totalCost = 0;
        while (set.size() < n + 1){
            int[] edge = edgesHeap.poll();
            int cost = edge[0];
            int nextHouse = edge[1];

            if (set.contains(nextHouse)) continue;

            set.add(nextHouse); //will go to the next house so mark as visited first
            totalCost += cost; //add the cost

            //go to the next house and explore
            for (int[] neighborEdge : graph.get(nextHouse)){
                if (!set.contains(neighborEdge[1])){
                    edgesHeap.add(neighborEdge);
                }
            }
        }
        return totalCost;
    }
    //time beat 31%, space beat 16%

    
}
