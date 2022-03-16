package test.linkedlist;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author chen
 * @crete 2022-03-11-21:00
 *  链表中环的入口结点
 */
public class D_EntryNodeOfLoop {

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
        listNode4.next = listNode2;
        ListNode nodeOfLoop = EntryNodeOfLoop_new(listNode);
        System.out.println();
    }

    //一快一慢方法
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (slow != null && fast != null) {
            if (slow.next != null) {
                slow = slow.next;
            } else {
                return null;
            }

            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (slow == fast) {
                break;
            }
        }
        while (slow != pHead) {
            slow = slow.next;
            pHead = pHead.next;
        }
        return pHead;
    }

    //一快一慢方法
    public static ListNode EntryNodeOfLoop_new(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast.next != null && fast.next.next != null) {
            slow=slow.next;
            fast=fast.next.next;
            if (slow == fast) {
                while (slow != pHead) {
                    slow = slow.next;
                    pHead = pHead.next;
                }
                return pHead;
            }
        }

        return null;
    }

    //Hash方法
    public static ListNode EntryNodeOfLoop_Hash(ListNode pHead) {

        HashSet<ListNode> hashSet = new HashSet();
        hashSet.add(null);
        while (!hashSet.contains(pHead)){
            hashSet.add(pHead);
            pHead=pHead.next;
        }
        return pHead;
    }

    //Hash方法
    public static ListNode EntryNodeOfLoop_Hash_new(ListNode pHead) {
        HashSet<ListNode> hashSet = new HashSet();
        while ( pHead != null) {
            if (!hashSet.add(pHead)) {
                return pHead;
            }
            pHead=pHead.next;
        }
        return  null;
    }

}



