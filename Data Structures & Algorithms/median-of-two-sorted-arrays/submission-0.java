class Solution {
    //Brute forcing with two pointers
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int array1 = 0;
        int array2 = 0;
        int nums3[] = new int[nums1.length + nums2.length];
        int currIndex = 0;

        while (currIndex < nums3.length) {
            if (array1 < nums1.length && (array2 >= nums2.length || nums1[array1] <= nums2[array2])) {
                nums3[currIndex++] = nums1[array1++];
            } else {
                nums3[currIndex++] = nums2[array2++];
            }
        }


        int n = nums3.length;
        //if n = odd: return mid val
        if (n % 2 != 0) {
            return (double) nums3[n / 2];
        } else {
            //if n = even
            return (nums3[(n / 2) - 1] + nums3[n / 2]) / 2.0;
        }

    }
}
