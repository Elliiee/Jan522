public class Q1299 {
    // replace elements with the greatest element on right side
    public int[] replaceElements(int[] arr){
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--){
            int temp = max;

            if (arr[i] < max){
                max = arr[i];
            }

            arr[i] = temp;
        }

        return arr;
    }
    // 1. starts from the end;
    // 2. record the greatest element on the right side each time 
}
