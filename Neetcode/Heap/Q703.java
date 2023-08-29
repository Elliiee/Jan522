public class Q703 {
    /*
    703. Kth Largest Element in a Stream
     */
    class KthLargest{
        private static int k;
        private PriorityQueue<Integer> heap;

        public KthLargest(int k, int[] nums){
            this.k = k;
            this.heap = new PriorityQueue<>();

            for (int n : nums){
                heap.offer(n);
            }

            while (heap.size() > k){
                heap.poll();
            }
        }
    }
}
