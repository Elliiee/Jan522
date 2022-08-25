import java.util.Arrays;

public class Sort {
    //counting sort
    public void countingSort(int[] arr){
        int k = Arrays.stream(arr).max().getAsInt();
        int[] counts = new int[k+1];

        for (int a : arr)
            counts[a]++;

        int startingIndex = 0;
        for (int i = 0; i < k + 1; i++){
            int count = counts[i];
            counts[i] = startingIndex;
            startingIndex += count;
        }

        int[] result = new int[arr.length];
        for (int a : arr){
            result[counts[a]] = a;
            counts[a]++;
        }

        for (int i = 0; i < arr.length; i++)
            arr[i] = result[i];
    }
}
