# coding=utf-8
def makeMaxHeap(input, lo, hi, first):
    root = lo
    while True:
        child = 2 * root + 1
        if child >= hi:
            break
        if child + 1 < hi and input[first + child] < input[first + child + 1]:
            child = child + 1
        if input[first + root] >= input[first + child]:
            return
        input[first + root], input[first + child] = input[first + child], input[first + root]
        root = child

def makeMaxHeapRec(input, lo, hi, first):
    root = lo
    left = 2 * root + 1
    right = 2 * root + 2

    if left < hi and input[first + root] < input[first + left]:
        root = left
    
    if right < hi and input[first + root] < input[first + right]:
        root = right

    if root != lo:
        input[first + root], input[first + lo] = input[first + lo], input[first + root]
        makeMaxHeapRec(input, root, hi, first)

def sort(input, start, end):
    if input == None or len(input) <= 1:
        return
    first = start
    lo = start
    hi = end - start

    for i in range((hi - 1) / 2, -1, -1):
        makeMaxHeapRec(input, i, hi, first)

    for i in range(hi - 1, -1, -1):
        input[first], input[first + i] = input[first + i], input[first]
        makeMaxHeapRec(input, lo, i, first)

if __name__ == '__main__':
    input = [6, 5, 7, 8, 1, 3, 2, 4, 0]
    sort(input, 0, len(input))
    print(input)
    # i = [6, 5, 7, 8, 1, 3, 2, 4, 0]
    # makeMaxHeap(i, 0, len(input), 0)
    # print(i)
    # makeMaxHeapIter(input, 0, len(input), 0)
    # print(input)