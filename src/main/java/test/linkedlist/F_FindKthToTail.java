package test.linkedlist;

import java.util.Stack;

/**
 * @author chen
 * @crete 2022-03-16-23:15
 * 链表中倒数最后K个结点
 */
public class F_FindKthToTail {

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
        ListNode listNode5 = FindKthToTail_Calculate(listNode, 2);
        System.out.println();
    }

    //栈方法
    public static  ListNode FindKthToTail_Stack(ListNode pHead, int k) {
        if (k<=0){
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (pHead != null) {
            stack.add(pHead);
            pHead=pHead.next;
        }
        if (k>stack.size()){
            return null;
        }else{
            while (k-->1)stack.pop();
            return stack.pop();
        }
    }

    //计数法
    public static  ListNode FindKthToTail_Calculate(ListNode pHead, int k) {
        if (k<=0){
            return null;
        }
        int i=0;
        ListNode  result=pHead;
        while (pHead != null) {
            pHead=pHead.next;
            i++;
        }
        if (k>i){
            return null;
        }else{
            int end = i-k;
            while (end-->0)result=result.next;
            return result;
        }
    }

}
