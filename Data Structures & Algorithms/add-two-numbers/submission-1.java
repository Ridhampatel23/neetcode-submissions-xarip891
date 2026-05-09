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

    // Pretty easy , forgot the case where carry could be there,
    // Ask interviewer about the num range
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        int carry = 0;
        

        while(l1 != null || l2 != null || carry != 0){

            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;

            int addition = l1Val + l2Val + carry;
            // Carry value
            carry = addition / 10;

            res.next = new ListNode(addition % 10);
            res = res.next;

            // Null pointer checks before moving the pointer
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }


        // Make sure to return dummy.next instead of dummy coz dummy points to the
        // head which we used as 0
        return dummy.next;
        
    }
}
