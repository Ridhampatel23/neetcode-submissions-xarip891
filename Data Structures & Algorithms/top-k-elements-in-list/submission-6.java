class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); //num, freq
        int[] result = new int[k];

       for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
       }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]); 
        for (int key : map.keySet()) {
        heap.offer(new int[] {key, map.get(key)});
            if (heap.size() > k) heap.poll(); 
        }       

        int i = 0;
        while(heap.size() > 0){
           
            result[i] = heap.poll()[0];
            i++;
        }

        return result;
        }

        
}
