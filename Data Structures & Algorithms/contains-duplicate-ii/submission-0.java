class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++){
            if (i - left > k){
                window.remove(nums[left]);
                left++;
            }
            if (window.contains(nums[i])) {return true;}

            window.add(nums[i]);
        }
        return false;
    }
}