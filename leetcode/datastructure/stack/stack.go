package main

import (
	"errors"
	"fmt"
)

type Stack []interface{}

func (stack Stack) Len() int {
	return len(stack)
}

func (stack Stack) Cap() int {
	return cap(stack)
}

func (stack *Stack) push(val interface{}) {
	*stack = append(*stack, val)
}

func (stack *Stack) pop() (interface{}, error) {
	s := *stack
	if s.Len() == 0 {
		return nil, errors.New("empty stack cant pop")
	}

	val := s[s.Len()-1]
	*stack = s[:s.Len()-1]
	return val, nil
}

func (stack Stack) peek() (interface{}, error) {
	s := stack
	if len(s) == 0 {
		return nil, errors.New("empty stack cant pop")
	}

	return stack[s.Len()-1], nil
}

// func (stack Stack) display() {

// }

func main() {
	var stack Stack
	stack.push("abc")
	stack.push(1)
	stack.push(1.1)
	fmt.Println(stack)
	fmt.Println(stack.pop())
	fmt.Println(stack.peek())
	fmt.Println(stack.Len())
}
