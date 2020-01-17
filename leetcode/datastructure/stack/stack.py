# coding=utf-8

class stack(object):
    def __init__(self, val):
        self.MAX = val
        self.stackArray = []
        self.top = -1

    def isEmpty(self):
        return self.top < 0

    def isFull(self):
        return self.top == self.MAX - 1

    def push(self, val):
        if self.isFull():
            self.MAX = self.MAX * 2
        self.top = self.top + 1
        self.stackArray.append(val)

    def pop(self):
        if not self.isEmpty():
            self.top = self.top - 1
            return self.stackArray.pop()
        raise Exception('empty')
            
    def peek(self):
        if not self.isEmpty():
            return self.stackArray[self.top]
        raise Exception('empty')

    def display(self):
        pstr = ''
        for i in range(self.top, -1, -1):
            pstr = pstr + str(self.stackArray[i])
            pstr = pstr + '->'
        pstr = pstr + 'None'
        print pstr

if __name__ == "__main__":
    s = stack(10)
    for i in range(20):
        s.push(i)
    s.display()
    print s.peek()
    print s.pop()
    print s.peek()