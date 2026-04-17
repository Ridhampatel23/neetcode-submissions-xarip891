class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int n : nums){
            set.add(n);
        }
        for (int num : set){
            if (!set.contains(num - 1)){
            int currLength = 1;
            while (set.contains(num + currLength)) currLength++;
            longest = Math.max(longest, currLength);
        }
        }
        return longest;
    }
}
