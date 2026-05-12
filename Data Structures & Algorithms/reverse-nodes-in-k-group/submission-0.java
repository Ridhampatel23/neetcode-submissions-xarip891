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
    // Solution needs O(1) memory, but for my brute force
    // I plan to use a stack. We push k elements in the stack
    // and pop to reverse the links
    public ListNode reverseKGroup(ListNode head, int k) {

       
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;


        while (true){
            Stack<ListNode> stack = new Stack<>();
            ListNode curr = groupPrev.next;
        for (int i = 0; i < k && curr != null; i++){
            stack.push(curr);
            curr = curr.next;
        }

            if (stack.size() < k) break;

            ListNode groupNext = curr;

            ListNode prev = groupPrev;
            
            while(!stack.isEmpty()){
                ListNode node = stack.pop();
                prev.next = node;
                prev = node;
            }
            prev.next = groupNext;

            groupPrev = prev;

        }

        return dummy.next;
    }
}
