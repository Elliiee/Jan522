/*
66 Plus one
You are given a large integer represented as an integer array digits, where each digits[i]
is the ith digit of the integer. The digits are ordered from most significant to least
significant in left-to-right order. The larger integer does not contain any leading 0s.
Increment the large integer by one and return the resulting array of digits.
 */
public class Q66 {
    public int[] plusOne(int[] digits){
        int n = digits.length;
        for (int i = n-1; i >= 0; i--){
            if (digits[i] < 9){
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] new_number = new int[n+1];
        new_number[0] = 1;
        return new_number;
    }
}
