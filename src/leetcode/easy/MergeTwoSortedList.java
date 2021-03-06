package leetcode.easy;

// Leetcode problem N21
// Related Topic: Linked List, Recursion
//        You are given the heads of two sorted linked lists list1 and list2.
//        Merge the two lists in a one sorted list.
//        The list should be made by splicing together the nodes of the first two lists.
//        Return the head of the merged linked list.

public class MergeTwoSortedList {
    public static void main(String[] args) {

        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode result1 = solution1.mergeTwoLists(list1,list2);
        printList(result1);

        ListNode list3 = new ListNode(1);
        list3.next = new ListNode(2);
        list3.next.next = new ListNode(4);

        ListNode list4 = new ListNode(1);
        list4.next = new ListNode(3);
        list4.next.next = new ListNode(4);

        ListNode result2 = solution2.mergeTwoLists(list3,list4);
        printList(result2);

    }

    public static void printList(ListNode node){
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    //    Definition for singly-linked list.
    static class ListNode {
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

    // Iterative approach
    static class Solution1 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode temp = new ListNode(-1);
            ListNode head = temp;

            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    temp.next = list1;
                    list1 = list1.next;
                } else {
                    temp.next = list2;
                    list2 = list2.next;
                }
                temp = temp.next;
            }
            if (list1 != null) temp.next = list1;
            if (list2 != null) temp.next = list2;

            return head.next;
        }
    }

    // Recursive approach
    static class Solution2 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;

            if (list1.val < list2.val) {
                list1.next = this.mergeTwoLists(list1.next, list2);
                return list1;

            } else {
                list2.next = this.mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
    }
}
