package test.linkedlist;

/**
 * @author chen
 * @crete 2022-03-10-23:03
 */
public class C_Merge {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(6);
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode merge = Merge_recursive(listNode, listNode3);
        System.out.println();
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head=head.next;
        }
        if (list1==null){
            head.next =list2;
        }else{
            head.next =list1;
        }
        return result.next;
    }

    public static ListNode Merge_recursive(ListNode list1,ListNode list2) {
        if (list1==null) {
            return list2;
        }
        if (list2==null) {
            return list1;
        }
        if (list1.val < list2.val){
            list1.next=Merge_recursive(list1.next,list2);
            return list1;
        }else{
            list2.next=Merge_recursive(list1,list2.next);
            return list2;
        }

    }

}
