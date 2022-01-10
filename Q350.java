import java.util.Arrays;

/*
350 Intersection of Two Arrays II
Given two integer arrays nums1 and nums2, return an array of their intersection. Each
element in the result must appear as many times as it shows in both arrays and you may return
the result in any order.
 */
public class Q350 {
    public int[] intersect(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]){
                i++;
            } else if (nums1[i] > nums2[j]){
                j++;
            } else {
                nums1[k++] = nums2[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
