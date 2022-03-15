package test.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author chen
 * @crete 2022-03-11-22:08
 * 两个链表的第一个公共结点
 */
public class E_FindFirstCommonNode {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(7);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        listNode5.next=listNode6;
        listNode6.next=listNode3;
        ListNode listNode7 = FindFirstCommonNode_difference(listNode, listNode5);
        System.out.println();

    }

    //set
    public static ListNode FindFirstCommonNode_set(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null) {
            return null;
        }
        HashSet<ListNode> hashSet = new HashSet<>();
        while (pHead1!=null) {
            hashSet.add(pHead1);
            pHead1=pHead1.next;
        }
        while (!hashSet.contains(pHead2)){
            pHead2=pHead2.next;
        }
        if (hashSet.contains(pHead2)){
            return pHead2;
        }
        return null;
    }

    //栈
    public static ListNode FindFirstCommonNode_stack(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1=pHead1.next;
        }
        Stack<ListNode> stack2 = new Stack<>();
        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2=pHead2.next;
        }
        ListNode result=null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            result=stack1.pop();
            if (!result.equals(stack2.pop())){
                return result;
            }
        }
        return null;
    }

    //差值
    public static ListNode FindFirstCommonNode_difference(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null) {
            return null;
        }
        int i=0;
        int z=0;
        ListNode result=pHead1;
        while (result != null) {
            i++;
            result=result.next;
        }
        result=pHead2;
        while (result != null) {
            z++;
            result=result.next;
        }
        int  a=i-z;
        if (a>0){
            for (int j = 0; j < a; j++) {
                pHead1=pHead1.next;
            }
        }else{
            for (int j = 0; j < -a; j++) {
                pHead2=pHead2.next;
            }
        }

        while (pHead1!=null && pHead2!=null){
            if (pHead1.equals(pHead2)){
                return pHead1;
            }
            pHead1=pHead1.next;
            pHead2=pHead2.next;
        }
        return null;
    }

    //等值法


}
