import java.util.*;

public class Q210 {
    public int[] findOrder(int numCourses, int[][] prerequisites){
        boolean isPossible = true;

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        //create the adjacency list representing of the graph
        for (int i = 0; i < prerequisites.length; i++){
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            adjList.put(src, lst);

            //record indegree of each vertex
            indegree[dest] += 1;
        }

        //add all nodes with 0 indegree to the queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0)
                q.add(i);
        }

        int i = 0;
        while (!q.isEmpty()){
            int node = q.remove();
            topologicalOrder[i++] = node;

            //removed the node from the queue
            //so reduce the indegree of each neighbor by 1
            if (adjList.containsKey(node)){
                for (Integer neighbor : adjList.get(node)){
                    indegree[neighbor]--;

                    //add those indegree == 0 nodes to the queue
                    if (indegree[neighbor] == 0)
                        q.add(neighbor);
                }
            }
        }

        //if topological sort is possible return the answer;
        if (i == numCourses)
            return topologicalOrder;

        //since it's impossible, return [0];
        return new int[0];
    }
}
