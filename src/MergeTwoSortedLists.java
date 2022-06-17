/**
 * Runtime: 1 ms, faster than 72.45% of Java online submissions for Merge Two Sorted Lists.
 * Memory Usage: 43.4 MB, less than 27.23% of Java online submissions for Merge Two Sorted Lists.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null && list2 == null) {
            return null;
        }
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        ListNode mergedListNodeHead = null;
        ListNode mergedListNodeCurrent = null;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (mergedListNodeHead == null) {
                    mergedListNodeHead = new ListNode(list1.val, null);
                    mergedListNodeCurrent = mergedListNodeHead;
                } else {
                    mergedListNodeCurrent.next = new ListNode(list1.val, null);
                    mergedListNodeCurrent = mergedListNodeCurrent.next;
                }
                list1 = list1.next;
            } else {
                if (mergedListNodeHead == null) {
                    mergedListNodeHead = new ListNode(list2.val, null);
                    mergedListNodeCurrent = mergedListNodeHead;
                } else {
                    mergedListNodeCurrent.next = new ListNode(list2.val, null);
                    mergedListNodeCurrent = mergedListNodeCurrent.next;
                }
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            mergedListNodeCurrent.next = new ListNode(list1.val);
            mergedListNodeCurrent = mergedListNodeCurrent.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            mergedListNodeCurrent.next = new ListNode(list2.val);
            mergedListNodeCurrent = mergedListNodeCurrent.next;
            list2 = list2.next;
        }
        return mergedListNodeHead;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode listNodeOne = new ListNode();
        ListNode listNodeTwo = new ListNode();
        System.out.println(mergeTwoSortedLists.mergeTwoLists(listNodeOne, listNodeTwo));
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
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
}
