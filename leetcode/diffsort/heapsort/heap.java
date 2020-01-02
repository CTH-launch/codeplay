package leetcode.diffsort.heapsort;
import java.util.Arrays;
class heap {
    class data {
        int[] input;
        public data(int[] input) {
            this.input = input;
        }
        private int Len() {
            return input.length;
        }
        private void Swap(int a, int b) {
            int temp = input[a];
            input[a] = input[b];
            input[b] = temp;
        }
        private boolean Less(int a, int b) {
            return input[a] < input[b];
        }
        private void outPut() {
            System.out.println(Arrays.toString(input));
        }
    }
    private void sort(data input, int start, int end) {
        if (input == null || input.Len() <= 1) {
            return;
        }
        int first = start;
        int lo = start;
        int hi = end - start;
        for (int i = (hi - 1) / 2; i >= 0; i--) {
            makeMaxHeap(input, i, hi, first);
        }
        for (int i = hi - 1; i >= 0; i--) {
            input.Swap(first, first + i);
            makeMaxHeap(input, lo, i, first);
        }
    }
    private void makeMaxHeap(data input, int lo, int hi, int first) {
        int root = lo;
        while(true) {
            int child = 2 * root + 1;
            if (child >= hi) {
                break;
            }
            if (child + 1 < hi && input.Less(first + child, first + child + 1)) {
                child++;
            }
            if (!input.Less(first + root, first + child)){
                return;
            }
            input.Swap(first + root, first + child);
            root = child;
        }
    }
    public static void main(String[] args) {
        heap h = new heap();
        int[] input = {6, 5, 7, 8, 1, 3, 2, 4, 0};
        data in = h.new data(input);
        h.sort(in, 0, in.Len());
        in.outPut();
    }
}