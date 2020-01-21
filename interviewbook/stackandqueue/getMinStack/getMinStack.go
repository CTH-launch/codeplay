package main

import "fmt"

// Solution1:
// Stack implement stack
// type Stack []interface{}

// func (s Stack) isEmpty() bool {
// 	return len(s) <= 0
// }

// func (s *Stack) push(val interface{}) {
// 	stack := *s
// 	if s.isEmpty() {
// 		*s = append(*s, val)
// 		*s = append(*s, val)
// 		return
// 	}
// 	curMin := stack[len(stack)-1]
// 	if curMin.(int) >= val.(int) {
// 		curMin = val
// 	}
// 	*s = append(*s, val)
// 	*s = append(*s, curMin)
// }

// func (s *Stack) pop() (interface{}, error) {
// 	stack := *s
// 	if stack.isEmpty() {
// 		return nil, errors.New("empty")
// 	}
// 	val := stack[len(stack)-2]
// 	*s = stack[:len(stack)-2]
// 	return val, nil
// }

// func (s Stack) peek() (interface{}, error) {
// 	if s.isEmpty() {
// 		return nil, errors.New("empty")
// 	}
// 	return s[len(s)-2], nil
// }

// func (s Stack) getMin() (interface{}, error) {
// 	if s.isEmpty() {
// 		return nil, errors.New("empty")
// 	}
// 	return s[len(s)-1], nil
// }

// func main() {
// 	var stack Stack
// 	for i := 0; i < 5; i++ {
// 		stack.push(i)
// 	}

// 	for i := -1; i > -5; i-- {
// 		stack.push(i)
// 	}
// 	curMin, _ := stack.getMin()
// 	curTop, _ := stack.pop()

// 	curMin1, _ := stack.getMin()
// 	curTop1, _ := stack.peek()

// 	fmt.Printf("min: %d, top: %d, \nmin: %d, top: %d", curMin, curTop, curMin1, curTop1)
// }

// Solution2:

// Node implement listnode
type Node struct {
	val  int
	min  int
	next *Node
}

// List implememt linkedlist
type List struct {
	node *Node
	len  int
}

// New implement init
func New() *List {
	return &List{
		node: nil,
		len:  0,
	}
}

func (l List) isEmpty() bool {
	return l.len <= 0
}

func (l *List) push(val int) {
	n := l.node
	if n == nil {
		n = &Node{
			val:  val,
			min:  val,
			next: nil,
		}
		l.node = n
		l.len++
		return
	}
	curMin := n.min
	if curMin >= val {
		curMin = val
	}
	newHead := &Node{
		val:  val,
		min:  curMin,
		next: n,
	}
	l.node = newHead
	l.len++
}

func (l *List) pop() {
	if l.isEmpty() {
		return
	}
	n := l.node
	temp := n.next
	n.next = nil
	l.node = temp
	l.len--
}

func (l *List) top() int {
	if l.isEmpty() {
		return -1
	}
	n := l.node
	return n.val
}

func (l *List) getMin() int {
	if l.isEmpty() {
		return -1
	}
	n := l.node
	return n.min
}

func main() {
	list := New()
	for i := 0; i < 5; i++ {
		list.push(i)
	}

	for i := -2; i > -7; i-- {
		list.push(i)
	}

	curMin := list.getMin()
	curTop := list.top()

	list.pop()

	curMin1 := list.getMin()
	curTop1 := list.top()
	fmt.Printf("min: %d, top: %d, \nmin: %d, top: %d", curMin, curTop, curMin1, curTop1)
}
