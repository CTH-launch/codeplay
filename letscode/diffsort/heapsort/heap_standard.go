package main

import "fmt"

type Interface interface {
	Len() int
	Swap(i, j int)
	Less(i, j int) bool
}

type Intslice []int

func (input Intslice) Len() int           { return len(input) }
func (input Intslice) Swap(i, j int)      { input[i], input[j] = input[j], input[i] }
func (input Intslice) Less(i, j int) bool { return input[i] < input[j] }

func makeMaxHeap(data Interface, lo, hi, first int) {
	root := lo
	for {
		child := 2*root + 1
		if child >= hi {
			break
		}
		if child+1 < hi && data.Less(first+child, first+child+1) {
			child++
		}
		if !data.Less(first+root, first+child) {
			return
		}
		data.Swap(first+root, first+child)
		root = child
	}
	// fmt.Println(data)
}

func Sort(data Interface, start, end int) {
	first := start
	lo := 0
	hi := end - start

	for i := (hi - 1) / 2; i >= 0; i-- {
		makeMaxHeap(data, i, hi, first)
	}
	for i := hi - 1; i >= 0; i-- {
		data.Swap(first, first+i)
		makeMaxHeap(data, lo, i, first)
	}
}

func main() {
	input := Intslice{6, 5, 7, 8, 1, 3, 2, 4, 0}
	Sort(input, 0, input.Len())
	fmt.Println(input)
}
