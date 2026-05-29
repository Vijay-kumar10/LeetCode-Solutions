public class LC_61_Rotate_LinkedList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int length = 0;
        ListNode head1 = head;
        ListNode tail = null;
        while (head1 != null) {
            length++;
            tail = head1;
            head1 = head1.next;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        return reverse(head, k, length, tail);
    }

    public ListNode reverse(ListNode head, int k, int l, ListNode tail) {
        int n = l - k;
        ListNode prev = null;
        ListNode head1 = head;
        // break the connection
        while (n > 0) {
            prev = head1;
            head1 = head1.next;
            n--;
        }
        ListNode newHead = head1;
        prev.next = null; // connection break
        // connect the last with first
        tail.next = head;
        return newHead;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
