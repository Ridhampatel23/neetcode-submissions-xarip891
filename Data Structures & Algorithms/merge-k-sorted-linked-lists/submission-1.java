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

    /**
     * TIME COMPLEXITY: O(N log k)
     * - N = total number of nodes across all lists
     * - k = number of lists
     * 
     * SPACE COMPLEXITY: O(k)
     * - Priority queue holds at most k nodes (one per list)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        
        // O(1) - simple null check
        if (k == 0) return null;

        // O(1) - create empty min-heap (sorts by node value)
        // Comparator: smaller values have higher priority
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // ===== INITIALIZATION PHASE =====
        // Total: O(k log k)
        
        // O(k) - iterate through all k lists
        for (ListNode list : lists) {
            // O(1) - null check
            if(list != null) {
                // O(log k) - insert head node into heap
                // Heap size grows from 0 to k, so insertions cost: O(log 1) + O(log 2) + ... + O(log k) ≈ O(k log k)
                pq.offer(list);
            }
        }

        // ===== MERGING PHASE =====
        // Total: O(N log k)
        
        // O(1) - create dummy node to simplify list building
        ListNode res = new ListNode(0);
        ListNode curr = res;

        // O(N) - loop runs N times (process every node once)
        while(!pq.isEmpty()) {
            // O(log k) - extract minimum node from heap
            // Heap size stays at most k, so each removal/reorganization costs O(log k)
            // Total for N removals: O(N log k)
            ListNode node = pq.poll();

            // O(1) - check if current node has a next node
            if(node.next != null) {
                // O(log k) - insert next node into heap
                // We insert N-1 nodes total (every node except dummy nodes at end)
                // Total for N-1 insertions: O(N log k)
                pq.offer(node.next);
            }
            
            // O(1) - attach node to result list
            curr.next = node;
            // O(1) - move pointer forward
            curr = curr.next;
        }
        
        // O(1) - return actual head (skip dummy node)
        return res.next;

        // Total: O(k log k) + O(N log k) = O(N log k)
    }
}