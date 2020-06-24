package letscode.leetcode.zigzagconversion;
class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 0 || numRows == 0 || numRows == s.length()) {
            return s;
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        int cycle = numRows + numRows - 2;
        for (int i = 0; i < numRows; i++) {
            int idx = i;
            if (idx % cycle == 0 || idx % cycle == cycle / 2) {
                while (idx < len) {
                    sb.append(ch[idx]);
                    idx += cycle;
                }
            }
            else {
                int idxExtra = cycle - idx;
                while (idx < len || idxExtra < len) {
                    if (idx < len) {
                        sb.append(ch[idx]);
                        idx += cycle;
                    }
                    if (idxExtra < len) {
                        sb.append(ch[idxExtra]);
                        idxExtra += cycle;
                    }
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        String ans1 = new Solution().convert(input, 3);
        boolean valid1 = ans1.equals("PAHNAPLSIIGYIR");
        String ans2 = new Solution().convert(input, 4);
        boolean valid2 = ans2.equals("PINALSIGYAHRPI");
        System.out.println("ans1: " + ans1 + " " + valid1 + "\n" + "ans2: " + ans2 + " " + valid2);
    }
}