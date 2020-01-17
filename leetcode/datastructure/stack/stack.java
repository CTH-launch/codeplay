package leetcode.datastructure.stack;
import java.util.EmptyStackException;
class stack {
    int MAX;
    int[] stackArray;
    int top;
    public stack(int size) {
        this.MAX = size;
        this.stackArray = new int[MAX];
        this.top = -1;
    }

    private boolean isEmpty() {
        return top < 0;
    }

    private boolean isFull() {
        return top == MAX - 1;
    }

    private void resize() {
        int newSize = MAX * 2;
        int[] newArray = new int[newSize];
        for (int i = 0; i < MAX; i++) {
            newArray[i] = stackArray[i];
        }
        this.stackArray = newArray;
        this.MAX = newSize;
    }

    private void push(int val) {
        if (!isFull()) {
            this.stackArray[++this.top] = val;
        }
        else {
            resize();
            this.stackArray[++this.top] = val;
        }
    }

    private int pop() {
        if (!isEmpty()) {
            return this.stackArray[this.top--];
        }
        else {
            throw new EmptyStackException();
        }
    }

    private int peek() {
        if (!isEmpty()) {
            return this.stackArray[this.top];
        }
        else {
            throw new EmptyStackException();
        }
    }

    private void display() {
        String str = "";
        int cnt = this.top;
        while (cnt != -1) {
            str += this.stackArray[cnt--];
            str += "->";
        }
        str += "null";
        System.out.println(str);
    }

    public static void main(String[] args) {
        stack stackArray = new stack(10);
        for (int i = 0; i < 12; i++) {
            stackArray.push(i);
        }
        stackArray.display();
        System.out.println(stackArray.pop() + "->" + stackArray.peek());
    }
}

