public class Q633 {
    //sum of square numbers
    // two pointers
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;

        long left = 0, right = (long)Math.sqrt(c);
        while(left <= right){
            long powSum = left * left + right * right;

            if (powSum == c)
                return true;
            else if (powSum > c)
                right--;
            else
                left++;
        }

        return false;
    }
}
