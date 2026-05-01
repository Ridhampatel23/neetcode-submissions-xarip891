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
    //single pass
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = res;

        for(int i = 0; i < n; i++){
           fast = fast.next; 
        }

        while(fast != null){
            slow = slow.next; fast = fast.next;
        }

        ListNode temp = new ListNode(0);
        slow.next = slow.next.next;

        return res.next;
    }
}
