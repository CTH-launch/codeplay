package leetcode.diffsort.mergesort;
import java.util.Arrays;
class merge{
    public static void mergeSort(int[] input) {
        if (input == null || input.length <= 1) {
            return;
        }
        int[] output = new int[input.length];
        sort(input, output, 0, input.length - 1);
        System.out.println(Arrays.toString(output));
    }
    public static void sort(int[] input, int[] output, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(input, output, start, mid);
        sort(input, output, mid + 1, end);

        int index = start;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (input[left] < input[right]) {
                output[index++] = input[left++];
            }
            else {
                output[index++] = input[right++];
            }
        }
        while (left <= mid) {
            output[index++] = input[left++];
        }
        while (right <= end) {
            output[index++] = input[right++];
        }
        for (int i = start; i <= end; i++) {
            input[i] = output[i];
        }
        return;
    }
    public static int[] mergeSortM(int[] input) {
        if (input == null || input.length <= 1) {
            return input;
        }
        int n = input.length;
        int[] l = new int[n / 2];
        int[] r = new int[n - n / 2];
        for(int i = 0; i < n / 2; i++) {
            l[i] = input[i];
        }
        for(int j = 0; j < (n - n / 2); j++) {
            r[j] = input[n / 2 + j];
        }
        int[] output = new int[n];
        int[] left = mergeSortM(l);
        int[] right = mergeSortM(r);
        int idx = 0;
        int i = 0;
        int j = 0;
        while (i < n / 2 && j < (n - n / 2)) {
            if (left[i] < right[j]) {
                output[idx++] = left[i++];
            }
            else {
                output[idx++] = right[j++];
            }
        }
        while (i < n / 2) {
            output[idx++] = left[i++];
        }
        while (j < n - n / 2) {
            output[idx++] = right[j++];
        }
        return output;
    }
    public static void main(String[] args) {
        int[] input = {6, 5, 7, 8, 1, 3, 2, 4, 0};
        int[] input1 = {6, 5, 7, 8, 1, 3, 2, 4, 0};
        mergeSort(input);
        int[] output = mergeSortM(input1);
        System.out.println(Arrays.toString(output));
    }
}