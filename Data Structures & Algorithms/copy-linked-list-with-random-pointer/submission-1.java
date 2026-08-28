/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
        return null;
    }
        Map<Node, Node> originToNew = new HashMap<>();

        Node curr = head;
        while (curr != null){
            originToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        Node dummy = head;
        while (dummy != null){
           originToNew.get(dummy).next = originToNew.get(dummy.next);
           originToNew.get(dummy).random = originToNew.get(dummy.random);    
           dummy = dummy.next;
        }

        return originToNew.get(head);
    }
}
