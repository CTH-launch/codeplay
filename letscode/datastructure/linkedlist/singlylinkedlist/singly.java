package letscode.datastructure.linkedlist.singlylinkedlist;

class singly{
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    ListNode head;
    private void insertHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head;
        head = newHead;
    }
    private void insertTail(int val) {
        ListNode newTail = new ListNode(val);
        ListNode dummy = head;
        while(dummy.next != null) {
            dummy = dummy.next;
        }
        dummy.next = newTail;
        newTail.next = null;
    }
    private void insertAfter(ListNode node, int val) throws Exception {
        ListNode newNode = new ListNode(val);
        ListNode dummy = head;
        while(dummy != node && dummy != null) {
            dummy = dummy.next;
        }
        if (dummy == null) {
            throw new Exception("no such node in list");
        }
        ListNode temp = dummy.next;
        dummy.next = newNode;
        newNode.next = temp;
    }
    private void delete(int pos) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(pos > 0 && dummy.next != null) {
            dummy = dummy.next;
            pos--;
        }
        if (dummy.next == null) {
            return;
        }
        ListNode temp = dummy.next;
        dummy.next = dummy.next.next;
        temp.next = null;
    }
    private ListNode reverse() {
        ListNode dummy = head;
        ListNode prev = null;
        while (dummy != null) {
            ListNode temp = dummy.next;
            dummy.next = prev;
            prev = dummy;
            dummy = temp;
        }
        return prev;
    }
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode newHead = new ListNode(0);
        ListNode dummy = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                dummy.next = l2;
                l2 = l2.next;
                dummy = dummy.next;
            }
            else {
                dummy.next = l1;
                l1 = l1.next;
                dummy = dummy.next;
            }
        }
        dummy.next = l1 == null ? l2 : l1;
        return newHead.next;
    }
    public static void main(String[] args) throws Exception {
        singly node = new singly();
        node.head = node.new ListNode(0);
        ListNode newHead = node.head;
        ListNode newHead2 = node.head;
        node.insertHead(2);
        node.insertTail(-2);
        node.insertAfter(node.head, 1);
        node.delete(2);
        newHead = node.reverse();
        ListNode dummy = newHead;
        String str = "";
        while(dummy != null) {
            str += dummy.val + "->";
            dummy = dummy.next;
        }
        System.out.println(str + "<nil>");
        ListNode newHead3 = node.merge(newHead, newHead2);

        str = "";
        while(newHead3 != null) {
            str += newHead3.val + "->";
            newHead3 = newHead3.next;
        }
        System.out.println(str + "<nil>");
    }
}