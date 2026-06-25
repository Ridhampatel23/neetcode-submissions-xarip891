class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        for (int s : stones){
            heap.offer(s);
        }

        while (heap.size() > 1){
            int first = heap.poll();
            int second = heap.poll();

            if (second != first) heap.offer(first - second);
        }
            heap.offer(0);
    return heap.peek();
    }


}
