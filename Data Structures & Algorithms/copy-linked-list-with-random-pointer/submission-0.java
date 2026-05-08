class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null; // Edge case
        
        Map<Node, Node> pointer = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            // Only create nodes for actual Node objects, not for null
            pointer.computeIfAbsent(curr, k -> new Node(k.val));

            if (curr.next != null) {
                pointer.computeIfAbsent(curr.next, k -> new Node(k.val));
                pointer.get(curr).next = pointer.get(curr.next);
            }

            if (curr.random != null) {
                pointer.computeIfAbsent(curr.random, k -> new Node(k.val));
                pointer.get(curr).random = pointer.get(curr.random);
            }

            curr = curr.next;
        }

        return pointer.get(head);
    }
}
