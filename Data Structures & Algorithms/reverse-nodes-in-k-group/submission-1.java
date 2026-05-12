/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    // Solution needs O(1) memory, so I would have to reverse in place
    public ListNode reverseKGroup(ListNode head, int k) {

       
      ListNode dummy = new ListNode(0, head);
      ListNode groupPrev = dummy;

    while (true) {
        // 1. Check if there are at least k nodes left
        ListNode kth = groupPrev;
        for (int i = 0; i < k && kth != null; i++) {
            kth = kth.next;
        }
        if (kth == null) break;          // fewer than k nodes remain

        ListNode groupNext = kth.next;

        // 2. Reverse the group
        ListNode prev = groupNext;
        ListNode curr = groupPrev.next;
        while (curr != groupNext){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }


       // 3. Connect the reversed group
        ListNode newTail = groupPrev.next;  // original head becomes tail
        groupPrev.next = kth;               // kth is the new head
        groupPrev = newTail; 


    }

    return dummy.next;
    }
}
