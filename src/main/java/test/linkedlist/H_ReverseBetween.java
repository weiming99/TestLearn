package test.linkedlist;

/**
 * @author chen
 * @crete 2022-03-20-19:40
 * 链表内指定区间反转
 */
public class H_ReverseBetween {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode5 = reverseBetween(listNode, 2, 8);
        System.out.println();
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (n <= m) {
            return head;
        }
        ListNode result = new ListNode(-1);
        result.next = head;
        head = result;
        int index = 1;

        ListNode pre = head;
        ListNode last = head;
        while (head.next != null) {
            if (index == m) {
                pre = head.next;
                last = pre;
                head.next = pre.next;
            } else if (index == n) {
                ListNode tmp = head.next.next;
                head.next.next = last;
                pre.next = tmp;
                break;
            } else if (index > m && index < n) {
                ListNode tmp = head.next;
                head.next = head.next.next;
                tmp.next = last;
                last = tmp;
            } else {
                head = head.next;
            }
            index++;
        }
        return result.next;
    }

}
