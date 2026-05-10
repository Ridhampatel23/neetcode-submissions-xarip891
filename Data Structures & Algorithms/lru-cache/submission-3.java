public class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }


/* 
Cases to be worried about:
Make sure to update the prev and next pointer for the MRU along with left and heads pointers
Make sure to update the map when you update an entry
Make sure to remove the LRU once the capacity is reached
Make sure to update the map when you remove the LRU
*/

class LRUCache {

    private int capacity;
    private Map<Integer, Node> map; // Key , Node address
    //Dummy nodes : essentially we will keep the MRU to the left and LRU to the right
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Initialize the dummy nodes
        this.left = new Node (0, 0);
        this.right = new Node (0 , 0);

        // Initialize the double links
        this.left.next = this.right;
        this.right.prev = this.left;
        
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);

        // Update the MRU
        remove(node);
        addToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {

        //if key already exists, we remove it from the linked list
        if (map.containsKey(key)){
            remove(map.get(key));
        }

        //And then update the map and the MRU pointers
        Node toAdd = new Node(key, value);

        //update map
        map.put(key, toAdd);

        //update MRU pointers
        addToFront(toAdd);

        if (map.size() > capacity){
            Node toRemove = right.prev;
            remove(toRemove);

            map.remove(toRemove.key);
        }
        
    }


    //===================== Helper methods ========================
    public void remove(Node node){
        Node nxt = node.next;
        Node prv = node.prev;

        prv.next = nxt;
        nxt.prev = prv;
    }

    public void addToFront(Node node){
        Node head = left.next;

        // Update the head pointer to point the MRU
        left.next = node;
        node.prev = left;

        // Update the previous head pointers for the new MRU
        head.prev = node;
        node.next = head;

    }
}
