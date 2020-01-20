package letscode.diffsort.quicksort;
import java.util.Arrays;
class quick {
    public static int[] quickSort(int[] input) {
        if (input == null || input.length <= 0) {
            return input;
        }
        int n = input.length;
        sort(input, 0, n - 1);
        return input;
    }
    public static void sort(int[] input, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = input[start];
        int i = start; 
        int j = end;
        while (i <= j) {
            while (i <= j && input[i] < pivot) i++;
            while (i <= j && input[j] > pivot) j--;
            if (i <= j) {
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
                j--;
            }
        }
        sort(input, start, j);
        sort(input, i, end);
        return;
    }
    public int[] quickSortM(int[] input) {
        if (input == null || input.length <= 0) {
            return input;
        }
        int n = input.length;
        sortM(input, 0, n - 1);
        return input;
    }
    public void sortM(int[] input, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(input, start, end);
        sortM(input, start, pivot - 1);
        sortM(input, pivot + 1, end);
    }
    public int partition(int[] input, int start, int end) {
        if (start >= end) {
            return start;
        }
        int pivot = input[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (input[j] < pivot) {
                i++;
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            }
        }
        i++;
        int temp = input[i];
        input[i] = input[end];
        input[end] = temp;
        return i;
    }
    public static void main(String[] args) {
        quick q = new quick();
        int[] input = {6, 5, 7, 8, 1, 3, 2, 4, 0};
        int[] input1 = {6, 5, 7, 8, 1, 3, 2, 4, 0};
        int[] output1 = q.quickSortM(input1);
        int[] output = quickSort(input);
        System.out.println(Arrays.toString(output));
        System.out.println(Arrays.toString(output1));
    }
}