package interviewbook.stackandqueue.getMinStack;
import java.util.*;
// Solution1:
// class getMinStack {
//     private Deque<Integer> norStack;
//     private Deque<Integer> minStack;

//     public getMinStack() {
//         norStack = new ArrayDeque<>();
//         minStack = new ArrayDeque<>();
//     }

//     private int pop() {
//         if (norStack.isEmpty()) {
//             throw new EmptyStackException();
//         }
//         int val = norStack.pollFirst();
//         minStack.pollFirst();
//         return val;
//     }

//     private void push(int val) {
//         norStack.offerFirst(val);
//         if (minStack.isEmpty()) {
//             minStack.offerFirst(val);
//             return;
//         }
//         int curMin = minStack.peekFirst();
//         curMin = curMin < val ? curMin : val;
//         minStack.offerFirst(curMin);
//     }

//     private int getMin() {
//         return minStack.peekFirst();
//     }

//     public static void main(String[] args) {
//         getMinStack stack = new getMinStack();
//         for (int i = 0; i < 5; i++) {
//             stack.push(i);
//         }
//         for (int i = -5; i > -10; i--) {
//             stack.push(i);
//         }
//         int curMin = stack.getMin();
//         int top = stack.pop();
//         int curMin1 = stack.getMin();
//         System.out.println("min: " + curMin + "top: " + top + "min: " + curMin1);
//     }
// }

// Solution2:
class getMinStack {
    class Node {
        Node next;
        int val;
        int min;
        public Node(int val, int min) {
            this.val = val;
            this.min = min;
            this.next = null;
        }
    }

    Node head;
    public getMinStack() {
        this.head = null;
    }

    public void push(int val) {
        if (this.head == null) {
            this.head = new Node(val, val);
            return;
        }
        
        int curMin = head.min < val ? head.min : val;
        Node newHead = new Node(val, curMin);
        newHead.next = this.head;
        this.head = newHead;
        return;
    }

    public void pop() {
        if (this.head == null) {
            throw new EmptyStackException();
        }
        Node newHead = head.next;
        head.next = null;
        head = newHead;
    }

    public int top() {
        if (this.head == null) {
            throw new EmptyStackException();
        }
        return head.val;
    }

    public int getMin() {
        if (this.head == null) {
            throw new EmptyStackException();
        }
        return head.min;
    }

    public static void main(String[] args) {
        getMinStack stack = new getMinStack();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        for (int i = -1; i > -5; i--) {
            stack.push(i);
        }
        System.out.println("min: " + stack.getMin() + "top: " + stack.top());
        stack.pop();
        System.out.println("min: " + stack.getMin() + "top: " + stack.top());
    }
}