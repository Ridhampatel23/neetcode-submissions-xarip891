class MedianFinder {
    /**
     * WHY TWO HEAPS INSTEAD OF SORTING?
     * 1. Sorting an array: addNum would be O(1), but findMedian would require O(N log N) to sort.
     * 2. Insertion into a sorted list: O(N) to shift elements.
     * 3. Two Heaps: addNum is O(log N) and findMedian is O(1). 
     * This is the most efficient approach for a continuous stream of data.
     */
    
    // maxHeap stores the SMALLER half of the numbers (peek is the largest of the small half)
    PriorityQueue<Integer> maxHeap;
    // minHeap stores the LARGER half of the numbers (peek is the smallest of the large half)
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // STEP 1: Decide which heap the number belongs to.
        // If the number is larger than the smallest element of the "large half",
        // it belongs in the minHeap. Otherwise, it belongs in the maxHeap.
        if (!minHeap.isEmpty() && num > minHeap.peek()){
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }

        // STEP 2: Rebalance the heaps.
        // The median logic depends on the heaps being roughly equal in size.
        // If one heap becomes too large (size difference > 1), move the "middle" 
        // element to the other heap to maintain balance.
        if (minHeap.size() - maxHeap.size() > 1){
            // minHeap is too big; move the smallest of the large half to maxHeap
            maxHeap.offer(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() > 1){
            // maxHeap is too big; move the largest of the small half to minHeap
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        // If the total number of elements is even, both heaps will have the same size.
        // The median is the average of the two middle values (both heap tops).
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            // If the total number of elements is odd, the median is the top
            // of the heap that contains the extra element.
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
        }
    }
}