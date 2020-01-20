# coding=utf-8
def sort(input):
    if not input or not isinstance(input, list) or len(input) <= 0:
        return input
    output = merge(input)
    return output

def merge(input):
    if len(input) <= 1:
        return input
    output = []
    mid = len(input) / 2
    left = merge(input[:mid])
    right = merge(input[mid : len(input)])
    i = j = 0
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            output.append(left[i])
            i += 1
        else:
            output.append(right[j])
            j += 1
    while i < len(left):
        output.append(left[i])
        i += 1
    while j < len(right):
        output.append(right[j])
        j += 1
    return output

if __name__ == '__main__':
    input = [6, 5, 7, 8, 1, 3, 2, 4, 0]
    print (sort(input))