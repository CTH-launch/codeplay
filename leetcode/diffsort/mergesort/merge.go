package main

import "fmt"

func merge(input []int) []int {
	if len(input) <= 1 {
		return input
	}
	output := make([]int, 0, len(input))
	n := len(input) / 2
	left := merge(input[:n])
	right := merge(input[n:])
	i := 0
	j := 0
	for i < len(left) && j < len(right) {
		if left[i] < right[j] {
			output = append(output, left[i])
			i++
		} else {
			output = append(output, right[j])
			j++
		}
	}
	for i < len(left) {
		output = append(output, left[i])
		i++
	}
	for j < len(right) {
		output = append(output, right[j])
		j++
	}
	return output
}

func main() {
	input := []int{6, 5, 7, 8, 1, 3, 2, 4, 0}
	output := merge(input)
	fmt.Println(output)
}
