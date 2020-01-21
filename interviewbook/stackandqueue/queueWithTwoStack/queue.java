package interviewbook.stackandqueue.queueWithTwoStack;
import java.util.*;
class queue {
    Deque<Integer> s1;
    Deque<Integer> s2;
    
    public queue() {
        this.s1 = new ArrayDeque<>();
        this.s2 = new ArrayDeque<>();
    }

    public void add(int val) {
        s1.offerFirst(val);
    }

    public int poll() {
        if (s1.isEmpty() && s2.isEmpty()) {
            throw new EmptyStackException();
        }
        else if (s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.offerFirst(s1.pollFirst());
            }
        }
        return s2.pollFirst();
    }

    public int peek() {
        if (s1.isEmpty() && s2.isEmpty()) {
            throw new EmptyStackException();
        }
        else if (s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.offerFirst(s1.pollFirst());
            }
        }
        return s2.peekFirst();
    }

    public static void main(String[] args) {
        queue q = new queue();
        for (int i = 0; i < 5; i++) {
            q.add(i);
        }
        System.out.println("top:" + q.peek() + "poll:" + q.poll() + "top:" + q.peek());
    }
}