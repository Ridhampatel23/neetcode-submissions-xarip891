class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
         PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> Integer
                            .compare(b[0] * b[0] + b[1] * b[1],
                                      a[0] * a[0] + a[1] * a[1]));
        

        for (int[] num : points){
            heap.offer(num);
            if (heap.size() > k){
                heap.poll();
            }
        } 
        
        int i = 0;
        while (!heap.isEmpty()){
            res[i++] = heap.poll();
        }
        return res;
    }
}
