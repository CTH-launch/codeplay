# coding=utf-8
class ListNode(object):
    def __init__(self, data):
        self.data = data
        self.next = None

class SinglyListNode(object):
    def __init__(self, object):
        self.head = ListNode(object)

    def insertHead(self, data):
        node = ListNode(data)
        node.next = self.head
        self.head = node
    
    def insertTail(self, data):
        node = ListNode(data)
        dummy = self.head
        while dummy.next != None:
            dummy = dummy.next
        dummy.next = node

    def insertAfter(self, pos, data):
        if pos == 0:
            self.insertHead(data)
            return
        node = ListNode(None)
        node.next = self.head
        while pos > 0 and node != None:
            pos = pos - 1
            node = node.next
        if node == None:
            raise Exception('no such position')
        newNode = ListNode(data)
        temp = node.next
        node.next = newNode
        newNode.next = temp

    def delete(self, pos, data):
        node = ListNode(None)
        node.next = self.head
        while pos > 0 and node != None:
            pos = pos - 1
            node = node.next
        
        if node == None:
            raise Exception('no such position')
        
        temp = node.next
        node.next = node.next.next
        temp.next = None

    def display(self):
        node = self.head
        s = ''
        while node != None:
            s = s + str(node.data) + '->'
            node = node.next
        print s + '<nil>'

if __name__ == "__main__":
    singlyList = SinglyListNode(0)
    singlyList.display()
    singlyList.insertHead(1)
    singlyList.insertHead(2)
    singlyList.display()
    singlyList.insertTail(-1)
    singlyList.display()