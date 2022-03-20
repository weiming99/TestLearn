package test.linkedlist;

/**
 * @author chen
 * @crete 2022-03-19-0:00
 * 删除节点
 */
public class G_DeleteNode {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(1);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode5 = deleteNode_new(listNode, 1);
        System.out.println();

    }

    //三指针
    public static ListNode deleteNode (ListNode head, int val) {
        if (head==null) {
            return  null;
        }else {
            while (head != null && head.val == val) {
                head=head.next;
            }
        }

        ListNode result=head;
        ListNode pre=head;
        while (head != null) {
            if (head.val==val){
                pre.next=head.next;
                head.next=null;
                head=pre.next;
            }else{
                pre=head;
                head=head.next;
            }

        }

        return result;
    }

    //双指针 todo ★☆★☆★☆★☆
    public static ListNode deleteNode_new(ListNode head, int val) {
        ListNode tmp=new ListNode(-1);
        tmp.next=head;
        head=tmp;
        while (head.next != null) {
            if (head.next.val == val) {
                head.next=head.next.next;
            }else {
                head=head.next;
            }
        }
        return tmp.next;
    }

}
