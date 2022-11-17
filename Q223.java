public class Q223 {
    /*
    223 Rectangle Area
    Given the coordinates of two rectilinear rectangles in a 2D plane,
    return the total area covered by the two rectangles.
     */

    //The two rectangles could potentially overlap with each other.
    //area covered = a + b - overlap

    /*
    How to find the overlap area?
    x overlap = min(ax2, bx2) - max(ax1, bx1)
    y overlap is the same calculation.
     */

    public int computeArea(int ax1, int ay1, int ax2, int ay2,
                           int bx1, int by1, int bx2, int by2) {
        int areaA = (ay2 - ay1) * (ax2 - ax1);
        int areaB = (by2 - by1) * (bx2 - bx1);

        int xOverlap = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int yOverlap = Math.min(ay2, by2) - Math.max(ay1, by1);

        int areaOverlap = 0;

        if (xOverlap > 0 && yOverlap > 0){ // you can't omit this step, otherwise answer is
            //not accepted
            areaOverlap = xOverlap * yOverlap;
        }

        int totalArea = areaA + areaB - areaOverlap;

        return totalArea;
    }
}
