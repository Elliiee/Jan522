import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1046 {
    // last stone weight
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n2 - n1);

        for (int s : stones){
            heap.offer(s);
        }

        while (heap.size() > 1){
            int stone1 = heap.poll();
            int stone2 = heap.poll();
            if (stone1 != stone2){
                heap.offer(stone1 - stone2);
            }
        }

        return heap.isEmpty() ? 0 : heap.poll();
    }
}
