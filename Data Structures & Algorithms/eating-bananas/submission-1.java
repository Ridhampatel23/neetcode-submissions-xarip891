class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int result = Integer.MAX_VALUE;
    

        while(left <= right){
            int mid = left + (right - left) / 2;
            int totalTime = 0;
            for (int pile : piles){
                totalTime += Math.ceil((double)pile / mid);
            }
            
            if(totalTime <= h){
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
