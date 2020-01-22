package interviewbook.stackandqueue.recursiveReverseStack;
import java.util.*;
// this alg using a small trick - recursion stack, very interesting
class stack {
    // try to get bottom element for each recursion in stack
    public int getLast(Stack<Integer> stack) {
        int last = stack.pop();
        if (stack.isEmpty()) {
            return last;
        }
        int ret = getLast(stack);
        stack.push(last);
        return ret;
    }
    // using getLast func to get bottom element, and push reversely
    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = getLast(stack);
        reverse(stack);
        stack.push(last);
    }

    public static void main(String[] args) {
        stack s = new stack();
        Stack<Integer> st = new Stack<>();
        for (int i = 1; i <=5; i++) {
            st.push(i);
        }
        s.reverse(st);
        String str = "";
        while (!st.isEmpty()) {
            str += st.pop() + "->";
        }
        System.out.println(str + "null");
    }
}