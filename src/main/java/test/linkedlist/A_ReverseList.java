package test.linkedlist;

import java.util.Stack;

/**
 * @author chen
 * @crete 2022-03-08-21:56
 *  反转链表
 */


public class A_ReverseList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;

        ListNode listNode3 = learnStack(listNode);
        System.out.println();
    }


    //反转链表1
    public static ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        ListNode pop = stack.pop();
        ListNode result = pop;
        while (!stack.isEmpty()) {
            ListNode tmp = stack.pop();
            pop.next = tmp;
            pop = tmp;
        }
        pop.next = null;
        return result;
    }

    //反转链表二
    public static ListNode ReverseList_new(ListNode head) {
        ListNode pre = null;
        ListNode next = head;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }




    public static ListNode learnStack(ListNode head) {
        if (head==null){
            return  head;
        }
        ListNode next =head.next;
        head.next=null;
        while (next!=null){
            ListNode tmp = next.next;
            next.next=head;
            head=next;
            next=tmp;
        }
        return  head;
    }

}
