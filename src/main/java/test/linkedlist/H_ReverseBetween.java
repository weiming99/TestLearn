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
        ListNode listNode5 = reverseBetween_myself(listNode, 2, 4);
        System.out.println();
    }

    public static ListNode reverseBetween_myself(ListNode head, int m, int n) {
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode pre=result;
        for (int i = 0; i < m - 1; i++) {
            pre=pre.next;
        }

        ListNode cur=pre.next;
        ListNode cur_next=null;
        for (int i = 0; i < n - m ; i++) {
            cur_next=cur.next;
            cur.next=cur_next.next;
            cur_next.next=pre.next;
            pre.next=cur_next;
        }
        return result.next;
    }


    //自己 逐步拆分
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

    //双指针（局部反转）
    public static ListNode reverseBetween_new(ListNode head, int m, int n) {
        if (m>=n) {
            return head;
        }
        ListNode result = new ListNode(-1);
        result.next = head;

        ListNode pre=result;
        for (int i = 0; i < m-1; i++) {
            pre=pre.next;
            if (pre==null) {
                return head;
            }
        }

        ListNode right=pre;
        for (int i = 0; i < n - m + 1; i++) {
            right=right.next;
            if (right==null) {
                return head;
            }
        }

        ListNode left=pre.next;
        ListNode last=right.next;

        pre.next=null;
        right.next=null;
        reverse(left);
        pre.next=right;
        left.next=last;

        return result.next;
    }

    //反转链表
    public static  void  reverse(ListNode head){
        ListNode pre=null;
        while (head != null) {
            ListNode tmp =head.next;
            head.next=pre;
            pre=head;
            head=tmp;
        }
    }

}
