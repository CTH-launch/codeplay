# coding=utf-8
import argparse
import sys

def swap(i, j, input):
    # b = a ^ b
    # a = b ^ a
    # b = a ^ b
    temp = input[j]
    input[j] = input[i]
    input[i] = temp

def bubble_sort(input):
    if not input or not isinstance(input, list) or len(input) <= 0:
        return input
    for i in range(len(input)):
        for j in range(i + 1, len(input)):
            if input[j] < input[i]:
                # temp = input[j]
                # input[j] = input[i]
                # input[i] = temp
                swap(i, j, input)
    return input

if __name__ == "__main__":
    arg_parser = argparse.ArgumentParser()
    arg_parser.add_argument('--input', type=str, default=None)
    args = arg_parser.parse_args(sys.argv[1:])
    print(args.input)
    input = args.input.split(',')
    output = bubble_sort(input)
    print output