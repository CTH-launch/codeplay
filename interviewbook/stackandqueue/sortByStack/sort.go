package main

import "fmt"

// Stack implement
type Stack []int

func (s Stack) isEmpty() bool {
	return len(s) <= 0
}

func (s *Stack) push(val int) {
	*s = append(*s, val)
}

func (s *Stack) pop() int {
	stack := *s
	if stack.isEmpty() {
		return -1
	}
	val := stack[len(stack)-1]
	*s = stack[:len(stack)-1]
	return val
}

func (s *Stack) peek() int {
	stack := *s
	if stack.isEmpty() {
		return -1
	}
	return stack[len(stack)-1]
}

func sort(s *Stack) {
	stack := *s
	var side Stack

	for !stack.isEmpty() {
		val := stack.pop()
		for !side.isEmpty() && side.peek() > val {
			stack.push(side.pop())
		}
		side.push(val)
	}
	for !side.isEmpty() {
		stack.push(side.pop())
	}
}

func main() {
	var stack Stack
	for i := 0; i < 6; i++ {
		stack.push(i % 3)
	}
	fmt.Println(stack)
	sort(&stack)
	fmt.Println(stack)
}
