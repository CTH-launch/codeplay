package interviewbook.stackandqueue.maxTree;
import java.util.*;

/*
    1. select max(leftNearBigger, rightNearBigger) as father node
    2. if no left bigger and no right bigger, this is the root
*/
class makeMaxTree{
    class Node {
        Node left;
        Node right;
        int val;
        public Node(int val) {
            this.left = null;
            this.right = null;
            this.val = val;
        }
    }
    public void display(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int lv = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            String str = "lv-" + lv + ": ";
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (i != size - 1) {
                    str += cur.val + "->";
                }
                else str += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            System.out.println(str);
            lv++;
        }
    }
    public void helper(Map<Node, Node> map, Stack<Node> stack, Node node) {
        while (!stack.isEmpty() && stack.peek().val < node.val) {
            Node cur = stack.pop();
            Node temp = stack.isEmpty() ? null : stack.peek();
            map.put(cur, temp);
        }
        stack.push(node);
    }
    public void helperClean(Map<Node, Node> map, Stack<Node> stack) {
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            Node temp = stack.isEmpty() ? null : stack.peek();
            map.put(cur, temp);
        }
    }
    public Node makeTree(int[] input) {
        int len = input.length;
        Node[] nArr = new Node[len];
        for (int i = 0; i < len; i++) {
            nArr[i] = new Node(input[i]);
        }

        Stack<Node> ls = new Stack<>();
        Stack<Node> rs = new Stack<>();
        Map<Node, Node> lm = new HashMap<>();
        Map<Node, Node> rm = new HashMap<>();

        for (int i = 0; i < len; i++) {
            Node lcur = nArr[i];
            Node rcur = nArr[len - i - 1];
            helper(lm, ls, lcur);
            helper(rm, rs, rcur);
        }
        helperClean(lm, ls);
        helperClean(rm, rs);

        Node root = null;
        for (int i = 0; i < len; i++) {
            Node cur = nArr[i];
            Node left = lm.get(cur);
            Node right = rm.get(cur);
            
            if (left == null && right == null) {
                root = cur;
            }
            else if (left == null) {
                if (right.left == null) {
                    right.left = cur;
                }
                else right.right = cur;
            }
            else if (right == null) {
                if (left.left == null) {
                    left.left = cur;
                }
                else left.right = cur;
            }
            else {
                Node parent = left.val < right.val ? left : right;
                if (parent.left == null) {
                    parent.left = cur;
                }
                else parent.right = cur;
            }
        }
        return root;
    }
    public static void main(String[] args) {
        makeMaxTree a = new makeMaxTree();
        int[] input = {3, 4, 5, 1, 2};
        Node root = a.makeTree(input);
        a.display(root);
    }
}