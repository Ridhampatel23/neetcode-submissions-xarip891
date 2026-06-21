class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || k == 0) return new int[]{-1};
        int[] output = new int[n - k + 1];

        // Using deque, first time using its full potential
        // Could have only came up with heap implementation by myself
        Deque<int[]> dq = new ArrayDeque<>();
        int l = 0; int r = 0;

        while(r < n){

              // 1. Remove elements outside the window
            // Window range = [right - k + 1, right]
            // So remove anything <= right - k
            while(!dq.isEmpty() && dq.peekFirst()[0] <= r - k){
                dq.pollFirst();
            }

            // 2. Maintain decreasing order in deque
            // Remove all smaller elements from the back
            // because current element is better than them
            while(!dq.isEmpty() && dq.peekLast()[1] <= nums[r]){
                dq.pollLast();
            }

            // 3. Add current element
            dq.offerLast(new int[]{r, nums[r]});

            // 4. Record result once window size reaches k
            if(r >= k - 1){
                output[r - k + 1] = dq.peekFirst()[1];
            }
            r++;

            
        }

        return output;
         
    }
}
