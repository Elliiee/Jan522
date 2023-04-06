import java.util.*;

public class Q743 {
    /*
    743. Network Delay Time
    You are given a network of n nodes, labeled from 1 to n.
    You are given a list of travel time, times[i] = {ui, vi, wi}.
    ui is the source node, vi is the target node, wi is the time it takes to travel from source to target.
    Return the minimum time it takes for all the n nodes to receive the signal.
    We will send this signal from a given node k.
    Return -1, if it's impossible for all the nodes n to receive the signal.
     */

    //Solution
    /*
    Overview
    We have a network consisting of some nodes and directed edges.
    Each edge has 3 components: source, destination, and travel time.
    The timestamp of a node receives the signal is the first time it reaches the node.
    (keyword: the first time reaches). Multiple neighbors could send signals to the same node.
    But only the first time it receives the signal counts.
    So the timestamp of the last node received the signal is the answer to this question.
     */

    /*
    Approach 1 DFS

     */
    Map<Integer, List<int[]>> adj = new HashMap<>();

    private void dfs(int[] signalReceivedAt, int currNode, int currTime){
        //If the current time is greater than or equal to the fastest signal received
        //then the signal has been received already, no need to do the work again
        if (currTime >= signalReceivedAt[currNode])
            return; //get out of the method

        //when you come to this step, means it's the first time the signal received
        signalReceivedAt[currNode] = currTime;

        //if there is no edge for the current node, get out of the method, no need to do anything
        if (!adj.containsKey(currNode))
            return;

        //broadcast the signal to the neighbors/adjacent nodes
        for (int[] edge : adj.get(currNode)){
            int neighborNode = edge[0];
            int travelTime = edge[1];
            dfs(signalReceivedAt, neighborNode, currTime + travelTime);
        }
    }

    public int networkDelayTimeDFS(int[][] times, int n, int k){
        //build the adjacency list
        for (int[] time : times){
            int source = time[0];
            int destination = time[1];
            int travelTime = time[2];

            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new int[]{destination, travelTime});
        }

        //sort the edges connecting to every node (why sort? I feel no need to sort)
        //(Yes, I've tried. Without the sorting, it is also accepted.)
        for (int node : adj.keySet()){
            Collections.sort(adj.get(node), (a, b) -> (a[0] - b[0]));
        }

        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        dfs(signalReceivedAt, k, 0);

        int answer = Integer.MIN_VALUE;
        for (int node = 1; node <= n; node++){
            answer = Math.max(answer, signalReceivedAt[node]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    /*
    Approach 2 BFS
    We will add each adjacent node to the queue only if the signal from currNode
    via the current edge takes less time than the fastest signal to reach the
    adjacent node so far.
     */
    private void bfs(int[] signalReceivedAt, int sourceNode){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceNode);

        //time for starting node is 0
        signalReceivedAt[sourceNode] = 0;

        while (!queue.isEmpty()){
            int currNode = queue.remove();

            if (!adj.containsKey(currNode))
                continue;

            for (int[] edge : adj.get(currNode)){
                int neighborNode = edge[0];
                int travelTime = edge[1];

                int arrivalTime = signalReceivedAt[currNode] + travelTime;
                if (signalReceivedAt[neighborNode] > arrivalTime){
                    signalReceivedAt[neighborNode] = arrivalTime;
                    queue.add(neighborNode);
                }
            }
        }
    }

    //public int networkDelayTimeBFS(int[][] times, int n, int k){
        //this method is almost the same as DFS
        //only need to change the dfs() method to bfs(signalReceivedAt, k).
    //}

    /*
    Approach 3 Dijkstra's Algorithm
    Our object is to find the fastest path from node k to the rest of the nodes.
    This is a typical use case for the Single Source Shortest Path algorithm.
    Dijkstra is very similar to the previous BFS.

    The difference is here we use Priority Queue to traverse the nodes in increasing
    order o the time required to reach them.
    Therefore, in each iteration, we will visit the node with the shortest traver time.
    This will help us find the fastest time path first.
     */
    private void dijkstra(int[] signalReceivedAt, int source, int n){
        //create min heap
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.add(new int[]{source, 0});

        signalReceivedAt[source] = 0; //time for starting node is 0

        while (!pq.isEmpty()){
            int[] topPair = pq.remove();
            int currNode = topPair[0];
            int travelTime = topPair[1];

            if (travelTime > signalReceivedAt[currNode])
                continue;

            if (!adj.containsKey(currNode))
                continue;

            for (int[] edge : adj.get(currNode)){
                int neighborTime = edge[1];
                int neighborNode = edge[0];

                if (signalReceivedAt[neighborNode] > travelTime + neighborTime){
                    signalReceivedAt[neighborNode] = travelTime + neighborTime;
                    pq.add(new int[]{neighborNode, signalReceivedAt[neighborNode]});
                }
            }
        }
    }
}
