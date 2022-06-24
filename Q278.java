public class Q278 {
    public int firstBadVersion(int n){
        int left = 0, right = n;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left == right && isBadVersion(left)){
            return left;
        }

        return -1;
    }

    public boolean isBadVersion(int n){
        //place holder
        return true;
    }
}
