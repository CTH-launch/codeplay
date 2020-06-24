package letscode.leetcode.longestpalindromicsubstring;
/*
    I. dynamic programming
        from defination of palindrome we know, if a string is a palindrome, we must ensure this string is same with reversed one
        so we can get dp[i][j] = if i <= j - 2 s[i] == s[j] && dp[i + 1][j - 1]
*/
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] ch = s.toCharArray();
        int len = ch.length;
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0;
        String ans = null;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (ch[i] != ch[j]) {
                    dp[i][j] = false;
                }
                else{
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    }
                    else dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j] && j - i + 1 >= maxLen) {
                        maxLen = j - i + 1;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }
    public String longestPalindromeV2(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        String ans = null;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            String ex1 = extend(i, i, s);
            String ex2 = extend(i, i + 1, s);
            String temp = ex1.length() >= ex2.length() ? ex1 : ex2;
            if (temp.length() >= maxLen) {
                maxLen = temp.length();
                ans = temp;
            }
        }
        return ans;
    }

    public String extend(int i, int j, String s) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            else {
                i--;
                j++;
            }
        }
        return s.substring(i + 1, j);
    }

    public static void main(String[] args) {
        String input1 = "leetcode";
        String input2 = "aabdeaedbffsg";
        String ans1 = new Solution().longestPalindrome(input1);
        String ans1v2 = new Solution().longestPalindromeV2(input1);
        String ans2 = new Solution().longestPalindrome(input2);
        String ans2v2 = new Solution().longestPalindromeV2(input2);
        System.out.println("ans1: " + ans1 + "\n" + "ans2: " + ans2);
        System.out.println("ans1v2: " + ans1v2 + "\n" + "ans2v2: " + ans2v2);
    }
}