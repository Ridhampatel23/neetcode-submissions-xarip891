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
    // My version of one pass
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        // 1. Move fast forward n steps
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 2. IMPORTANT: If fast is now null, it means n was equal to the length
        // of the list, so we need to remove the first node (the head).
        if (fast == null) {
            return head.next;
        }

        // 3. Move until fast.next is null. 
        // This ensures slow stops exactly ONE node before the target.
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 4. Delete the target
        slow.next = slow.next.next;

        return head;
    }
}
