package interviewbook.stackandqueue.towerOfHanoi;
import java.util.*;
/*
    Different from classic hanoi, this problem require each move must pass mid, eg: left -> mid -> right
    First glance, this problem match recursion very much, for each recursion we could make it iteration.
    So, here're two solutions.
*/
// Solution1 recursion
// class hanoi {
//     public int move(int item, String from, String mid, String to) {
//         if (item == 1) {
//             System.out.println("Move item " + item + " from " + from + " to " + mid);
//             System.out.println("Move item " + item + " from " + mid + " to " + to);
//             return 2;
//         }
//         int count1 = move(item - 1, from, mid, to);
//         System.out.println("Move item " + item + " from " + from + " to " + mid);
//         int count2 = move(item - 1, to, mid, from);
//         System.out.println("Move item " + item + " from " + mid + " to " + to);
//         int count3 = move(item - 1, from, mid, to);
//         return count1 + count2 + count3 + 2;
//     }
//     public static void main(String[] args) {
//         hanoi h = new hanoi();
//         int count = h.move(3, "A", "B", "C");
//         System.out.println(count);
//     }
// }

// Solution2 iteration
/*
    For each movement, we have four types.
    We need to prove only one move is valid, others are not.
    1). bigger one on bottom, smaller one on top;
    2). to make move less, we can't reverse movement from pre one;
    So, if we have LM, then next, we can't do ML, and only one of MR and RM is valid
*/
class hanoi {
    enum moveType {
        None, LM, MR, RM, ML
    }

    Stack<Integer> left = new Stack<>();
    Stack<Integer> mid = new Stack<>();
    Stack<Integer> right = new Stack<>();

    moveType preMove = moveType.LM;

    public int moveStack(moveType tryMove, moveType banMove, Stack<Integer> from, Stack<Integer> to, String f, String t) {
        if (banMove == preMove) {
            return 0;
        }
        
        if (from.isEmpty()) {
            return 0;
        }

        if (!to.isEmpty() && from.peek() < to.peek() || to.isEmpty()) {
            to.push(from.pop());
            System.out.println("Move item " + to.peek() + " from " + f + " to " + t);
            preMove = tryMove;
            return 1;
        }
        return 0;
    }

    public int move(int item) {
        for (int i = item; i > 0; i--) {
            left.push(i);
        }

        int step = 0;
        while(right.size() != item) {
            step += moveStack(moveType.LM, moveType.ML, left, mid, "A", "B");
            step += moveStack(moveType.ML, moveType.LM, mid, left, "B", "A");
            step += moveStack(moveType.MR, moveType.RM, mid, right, "B", "C");
            step += moveStack(moveType.RM, moveType.MR, right, mid, "c", "B");
        }
        return step;
    }

    public static void main(String[] args) {
        hanoi h = new hanoi();
        int step = h.move(2);
        System.out.println(step);
    }
}