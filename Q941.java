public class Q941 {
    // valid mountain array: strictly increase and then strictly decrease, no duplicates
    public boolean validMountainArray(int[] arr){
        int i = 0, N = arr.length;

        while (i + 1 < N && arr[i] < arr[i + 1]){
            i++;
        }

        // peak can't be the first or last element;
        if (i == 0 || i == N - 1){
            return false;
        }

        while (i + 1 < N && arr[i] > arr[i + 1]){
            i++;
        }

        return i == N - 1;
    }
}
