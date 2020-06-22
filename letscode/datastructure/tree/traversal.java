package letscode.datastructure.tree;
import java.util.*;
/*
    inorder traversal
*/
class traversal {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    private List<Integer> recursionTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        helper(ans, root);
        return ans;
    }
    private void helper(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        helper(list, root.left);
        list.add(root.val);
        helper(list, root.right);
    }
    private List<Integer> iterationTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.addFirst(cur);
                cur = cur.left;
            }
            cur = stack.removeFirst();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }
}