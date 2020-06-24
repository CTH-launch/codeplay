package letscode.leetcode.reverseinteger;

public class Solution {
    public int reverse(int x) {
        int flag = 1;
        if (x < 0) {
            flag = -1;
            x = -x;
        }
        int y = 0;
        while (x > 0) {
            int carry = x % 10;
            if (y > Integer.MAX_VALUE / 10 || y == Integer.MAX_VALUE && (Integer.MAX_VALUE - Integer.MAX_VALUE % 10) < carry) {
                return 0;
            }
            y = y * 10 + carry;
            x /= 10;
        }
        return y * flag;
    }
    public static void main(String[] args) {
        int input1 = -1963847412;
        int input2 = 1463847412;
        int input3 = 1563847412;
        int input4 = Integer.MIN_VALUE;
        int ans1 = new Solution().reverse(input1);
        int ans2 = new Solution().reverse(input2);
        int ans3 = new Solution().reverse(input3);
        int ans4 = new Solution().reverse(input4);
        System.out.println(ans1 + "\n" + ans2 + "\n" + ans3 + "\n" + ans4);
    }
}