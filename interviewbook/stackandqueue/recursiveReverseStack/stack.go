package main

import "fmt"

// Stack primitive
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
	*s = stack[:len(stack)-1]
	return stack[len(stack)-1]
}

func (s *Stack) peek() int {
	stack := *s
	if stack.isEmpty() {
		return -1
	}
	return stack[len(stack)-1]
}

func getBot(s *Stack) int {
	val := s.pop()
	if s.isEmpty() {
		return val
	}
	ret := getBot(s)
	s.push(val)
	return ret
}

func reverse(s *Stack) {
	if s.isEmpty() {
		return
	}
	val := getBot(s)
	reverse(s)
	s.push(val)
}

func main() {
	var stack Stack
	for i := 1; i <= 5; i++ {
		stack.push(i)
	}
	fmt.Println(stack)
	reverse(&stack)
	fmt.Println(stack)
}
