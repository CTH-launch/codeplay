package main

import (
	"fmt"
	"strconv"
)

// ListNode defination of node
type ListNode struct {
	next *ListNode
	val  interface{}
}

// List defination of List
type List struct {
	node *ListNode
	len  int
}

type singly interface {
	insertHead(val interface{})
	insertTail(val interface{})
	insertAfterNode(node *ListNode, val interface{})
	insertAfterPos(pos int, val interface{})
	deleteNode(node *ListNode)
	deletePos(pos int)
	reverse() *ListNode
	Len() int
	Display()
}

// New initial List
func New() *List {
	return &List{
		node: nil,
		len:  0,
	}
}

func (l *List) insertHead(val interface{}) {
	n := l.node
	newHead := &ListNode{
		next: nil,
		val:  val,
	}
	newHead.next = n
	l.node = newHead
	l.len++
}

func (l *List) insertTail(val interface{}) {
	n := l.node
	for n.next != nil {
		n = n.next
	}
	newTail := &ListNode{
		next: nil,
		val:  val,
	}
	n.next = newTail
	l.len++
}

func (l *List) insertAfterNode(node *ListNode, val interface{}) {
	if node == nil {
		return
	}
	n := l.node
	if node == n {
		l.insertHead(val)
		return
	}
	for n != node && n != nil {
		n = n.next
	}
	newNode := &ListNode{
		next: nil,
		val:  val,
	}
	tempNode := n.next
	n.next = newNode
	newNode.next = tempNode
	l.len++
}

func (l *List) insertAfterPos(pos int, val interface{}) {
	if pos == 0 {
		l.insertHead(val)
		return
	}
	n := l.node
	newHead := &ListNode{
		next: nil,
		val:  0,
	}
	newHead.next = n
	for pos > 0 && newHead != nil {
		pos--
		newHead = newHead.next
	}
	if newHead == nil {
		return
	}
	newNode := &ListNode{
		next: nil,
		val:  val,
	}
	tempNode := newHead.next
	newHead.next = newNode
	newNode = tempNode
	l.len++
}

func (l *List) deleteNode(node *ListNode) {
	n := l.node
	for n.next != node && n.next != nil {
		n = n.next
	}
	if n.next == nil {
		return
	}
	tempNode := n.next
	n.next = n.next.next
	tempNode.next = nil
	l.len--
}

func (l *List) deletePos(pos int) {
	n := l.node
	newHead := &ListNode{
		next: nil,
		val:  0,
	}
	newHead.next = n
	for pos > 0 && newHead.next != nil {
		newHead = newHead.next
		pos--
	}
	if newHead.next == nil {
		return
	}
	tempNode := newHead.next
	newHead.next = newHead.next.next
	tempNode.next = nil
	l.len--
}

func (l *List) reverse() *ListNode {
	n := l.node
	prev := &ListNode{}
	for n != nil {
		tempNode := n.next
		n.next = prev
		prev = n
		n = tempNode
	}
	return prev
}

// Len return length of list
func (l *List) Len() int {
	return l.len
}

// Display print List
func (l *List) Display() {
	n := l.node
	var str = ""
	for n != nil {
		switch n.val.(type) {
		case string:
			str += n.val.(string)
			break
		case int:
			str += strconv.Itoa(n.val.(int))
		}
		str += "->"
		n = n.next
	}
	str += "<nil>"
	fmt.Println(str)
}

func main() {
	l := New()
	l.insertHead(1)
	l.insertTail("asb")
	l.insertAfterPos(0, "bsd")
	n := l.node
	for n != nil {
		fmt.Println(n.val)
		n = n.next
	}
	l.Display()
}
