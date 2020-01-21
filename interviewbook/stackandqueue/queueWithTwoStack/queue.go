package main

import "fmt"

// Stack implement stack
type Stack []int

func (l *Stack) push(val int) {
	*l = append(*l, val)
}

func (l *Stack) pop() int {
	list := *l
	if len(list) == 0 {
		return -1
	}
	*l = list[:len(list)-1]
	return list[len(list)-1]
}

func (l *Stack) peek() int {
	list := *l
	if len(list) == 0 {
		return -1
	}
	return list[len(list)-1]
}

func (l Stack) isEmpty() bool {
	return len(l) <= 0
}

// Queue implement queue
type Queue struct {
	s1 *Stack
	s2 *Stack
}

// New init queue
func New() *Queue {
	return &Queue{
		s1: &Stack{},
		s2: &Stack{},
	}
}

func (q *Queue) add(val int) {
	que := *q
	if que.s1.isEmpty() {
		*que.s1 = append(*que.s1, val)
		return
	}
	que.s1.push(val)
}

func (q *Queue) poll() int {
	que := *q
	if que.s2.isEmpty() {
		for !que.s1.isEmpty() {
			que.s2.push(que.s2.pop())
		}
	}
	return que.s2.pop()
}

func (q *Queue) peek() int {
	que := *q
	if que.s2.isEmpty() {
		for !que.s1.isEmpty() {
			que.s2.push(que.s1.pop())
		}
	}
	return que.s2.peek()
}

func main() {
	queue := New()
	for i := 0; i < 5; i++ {
		queue.add(i)
	}
	fmt.Println(queue.peek())
}
