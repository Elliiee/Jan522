import java.util.PriorityQueue;

public class Q703 {
    //Kth the largest element in a stream
    private static int k;
    private PriorityQueue<Integer> heap;

    public Q703(int k, int[] nums){
        this.k = k;
        heap = new PriorityQueue<>();

        for (int n : nums){
            heap.offer(n);
        }

        while (heap.size() > k){
            heap.poll();
        }
    }

    public int add(int val){
        heap.offer(val);
        if (heap.size() > k){
            heap.poll();
        }

        return heap.peek();
    }
}
