package test.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @author chen
 * @crete 2022-03-10-22:02
 *  从尾到头打印链表
 */

public class B_PrintListFromTailToHead {


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        printListFromTailToHead_recursive(listNode).stream().forEach(System.out::println);
    }

    //利用栈遍历，最后再把栈弹出到列表
    public static ArrayList<Integer> printListFromTailToHead_stack(ListNode listNode) {
        Stack<Integer> stack = new Stack();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {  //todo ★☆★☆★☆★☆
            result.add(stack.pop());
        }
        return result;
    }

    //利用这个add的重载方法，但是本身就有复杂度
    public static ArrayList<Integer> printListFromTailToHead_add(ListNode listNode) {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        while (listNode != null) {
            integers.add(0,listNode.val);  //todo ★☆★☆★☆★☆
            listNode=listNode.next;
        }
        return integers;
    }
    //反转链表
    public static ArrayList<Integer> printListFromTailToHead_reverseList(ListNode listNode) {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        while (listNode != null) {
            integers.add(listNode.val);
            listNode=listNode.next;
        }
        Collections.reverse(integers);//todo ★☆★☆★☆★☆
        return integers;
    }

    //先反转链表，再遍历存入list
    public static ArrayList<Integer> printListFromTailToHead_reverse(ListNode listNode) {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        if (listNode==null){
            return integers;
        }
        ListNode next = listNode.next;
        listNode.next=null;
        while (next != null) {
            ListNode tmp = next.next;
            next.next=listNode;
            listNode=next;
            next=tmp;
        }
        while (listNode != null) {
            integers.add(listNode.val);
            listNode=listNode.next;
        }
        return integers;
    }

    //递归 recursive
    //todo ★☆★☆★☆★☆
    public static ArrayList<Integer> printListFromTailToHead_recursive(ListNode listNode) {
        if (listNode==null) {
            return new ArrayList<Integer>();
        }else{
            ArrayList<Integer> integers = printListFromTailToHead_recursive(listNode.next);
            integers.add(listNode.val);
            return integers;
        }

    }
}
