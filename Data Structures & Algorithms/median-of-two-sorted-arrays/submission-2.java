class Solution {
    //Using Binary search
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // we ensure nums1 is the smaller array to optimize our binary search (min(O(logN, logM)))
          if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0, high = n1;

        while(low <= high){
            // We take out smallest numbers from the smaller array 1st and then 
            // get the leftover numbers (since we need 1/2 of the entire size of two arrays)
            // from array 2nd
            int partition1 = low + (high - low) / 2;
            int partition2 = (n1 + n2 + 1) / 2 - partition1;

            int maxLeft1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = partition1 == n1 ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = partition2 == 0 ?  Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = partition2 == n2 ? Integer.MAX_VALUE : nums2[partition2];

            // Perfect condition where the left partition of our chosen binary search array
            // is smaller than the right partition
            if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1){
                // If n1 + n2 is even
                if ((n1 + n2) % 2 == 0){
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else { //if n1 + n2 is odd
                    return (double) Math.max(maxLeft1, maxLeft2);
                }

            // Too many elements from nums1, move left
            }else if (maxLeft1 > minRight2){
                high = partition1 - 1;
            // Too few elements from nums1, move right
            } else if (maxLeft2 > minRight1){
                low = partition1 + 1;
            }

        }
        return 0;
        
    }
    

}

