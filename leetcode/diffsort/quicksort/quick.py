# coding=utf-8
def quick(input):
    if not input or not isinstance(input, list) or len(input) <= 0:
        return input
    sort(input, 0, len(input) - 1)
    return input

def sort(input, start, end):
    if start >= end:
        return
    pivot = partition(input, start, end)
    sort(input, start, pivot - 1)
    sort(input, pivot + 1, end)

def partition(input, start, end):
    if start >= end:
        return
    pivot = input[end]
    i = start - 1
    j = start
    for j in range(start, end):
        if input[j] < pivot:
            i = i + 1
            input[i], input[j] = input[j], input[i]
    i = i + 1
    input[i], input[end] = input[end], input[i]
    return i

if __name__ == "__main__":
    input = [6, 5, 7, 8, 1, 3, 2, 4, 0]
    print (quick(input))
    