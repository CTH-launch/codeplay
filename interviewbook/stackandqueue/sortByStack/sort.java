package interviewbook.stackandqueue.sortByStack;
import java.util.*;

class sort {
    public void sortByStack(Stack<Integer> stack) {
        Stack<Integer> side = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!side.isEmpty() && side.peek() > cur) {
                stack.push(side.pop());
            }
            side.push(cur);
        }
        while (!side.isEmpty()) {
            stack.push(side.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 6; i++) {
            stack.push(i % 3);
        }
        String str = "";
        while (!stack.isEmpty()) {
            str += stack.pop() + "->";
        }
        str += "null";
        System.out.println(str);
        sort s = new sort();
        for (int i = 0; i < 6; i++) {
            stack.push(i % 3);
        }
        s.sortByStack(stack);
        str = "";
        while (!stack.isEmpty()) {
            str += stack.pop() + "->";
        }
        str += "null";
        System.out.println(str);
    }
}