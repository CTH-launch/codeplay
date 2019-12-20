package leetcode.diffsort.bubblesort;
import java.util.Arrays;
class bubble {
    public static int[] bubbleSort(int[] input) {
        if (input == null || input.length <= 0) {
            return input;
        }
        int n = input.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (input[j] < input[i]) {
                    int temp = input[j];
                    input[j] = input[i];
                    input[i] = temp;
                }
            }
        }
        return input;
    }

    public static void main(String[] args) {
        int[] input = {8, 3, 5, 2, 6, 1, 7, 8, 21, 4, 5, 6, 4};
        int[] output = bubbleSort(input);
        System.out.println(Arrays.toString(output));
    }
}