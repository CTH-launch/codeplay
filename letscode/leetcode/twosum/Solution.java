package letscode.leetcode.twosum;
import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) throws Exception{
        if (nums == null || nums.length < 2) {
            throw new Exception("input value error");
        }
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            double remain = target - nums[i];
            if (remain < Integer.MIN_VALUE || remain > Integer.MAX_VALUE) {
                continue;
            }
            int diff = (int)remain;
            if (map.containsKey(diff) && map.get(diff) != i) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) throws Exception {
        int[] input1 = {4, 5, 2, 1, 4, 6, 9, 7};
        int target1 = 10;
        int[] input2 = {Integer.MIN_VALUE, Integer.MAX_VALUE, 4, 2, 3, 5, 1, 6};
        int target2 = Integer.MIN_VALUE + 5;
        int[] ret1 = new Solution().twoSum(input1, target1);
        int[] ret2 = new Solution().twoSum(input2, target2);
        System.out.println(Arrays.toString(ret1));
        System.out.println(Arrays.toString(ret2));
    }
}