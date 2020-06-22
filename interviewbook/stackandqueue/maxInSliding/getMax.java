package interviewbook.stackandqueue.maxInSliding;
import java.util.*;

// lc239
// Deque simulate sliding window
class getMax {
    public int[] getMaxWindow(int[] input, int k) {
        if (input == null || input.length == 0 || k <= 1) {
            return input;
        }
        int len = input.length;
        int[] ans = new int[len - k + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && stack.peek() < i - k + 1) {
                stack.poll();
            }
            while (!stack.isEmpty() && input[stack.peekLast()] < input[i]) {
                stack.pollLast();
            }
            stack.offer(i);
            if (i >= k - 1) {
                ans[idx++] = input[stack.peek()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        getMax g = new getMax();
        int[] input = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] input1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] output = g.getMaxWindow(input, 3);
        int[] output1 = g.getMaxWindow(input1, 3);
        System.out.println(Arrays.toString(output));
        System.out.println(Arrays.toString(output1));
    }
}