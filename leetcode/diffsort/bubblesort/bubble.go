package main

import (
	"fmt"
)

func BubbleSort(input []int) []int {
	if input == nil {
		return input
	}
	n := len(input)
	if n <= 0 {
		return input
	}
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			if input[j] < input[i] {
				input[i], input[j] = input[j], input[i]
			}
		}
	}
	return input
}

func main() {
	input := []int{8, 3, 5, 2, 6, 1, 7, 8, 21, 4, 5, 6, 4}
	output := BubbleSort(input)
	fmt.Println(output)
}
