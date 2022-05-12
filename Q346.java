import java.util.ArrayList;
import java.util.List;

public class Q346 {
    private int size;
    List<Integer> queue = new ArrayList<>();

    public Q346(int size) {
        this.size = size;
    }

    public double next(int val) {
        queue.add(val);
        int windowSum = 0;

        for (int i = Math.max(0, queue.size() - size); i < queue.size(); i++){
            windowSum += (int)queue.get(i);
        }

        return windowSum * 1.0 / Math.min(queue.size(), size);
    }
}
