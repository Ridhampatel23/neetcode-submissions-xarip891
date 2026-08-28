class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> ans1 = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        List<Integer> ans2 = new ArrayList<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++){
            set2.add(nums2[i]);
        }

        for (int n : set1){
            if(!set2.contains(n)){
                ans1.add(n);
            }
        }

        for (int n : set2){
            if(!set1.contains(n)){
                ans2.add(n);
            }
        }

        return Arrays.asList(ans1, ans2);
    }
}