package main

import "fmt"

func quick(input []int) []int {
	if input == nil || len(input) <= 0 {
		return input
	}
	n := len(input)
	sort(input, 0, n-1)
	return input
}

func sort(input []int, start int, end int) {
	if start >= end {
		return
	}
	var pivot int = partition(input, start, end)
	sort(input, start, pivot-1)
	sort(input, pivot+1, end)
}

func partition(input []int, start int, end int) int {
	if start >= end {
		return start
	}
	var pivot int = input[end]
	var i int = start - 1
	for j := start; j < end; j++ {
		if input[j] < pivot {
			i++
			input[i], input[j] = input[j], input[i]
		}
	}
	i++
	input[i], input[end] = input[end], input[i]
	return i
}

func main() {
	input := []int{6, 5, 7, 8, 1, 3, 2, 4, 0}
	output := quick(input)
	fmt.Println(output)
}
