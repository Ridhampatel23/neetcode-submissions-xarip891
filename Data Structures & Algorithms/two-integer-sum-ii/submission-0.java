class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end){
            if (target > (numbers[start] + numbers[end])){
                start++;
            } else if (target < (numbers[start] + numbers[end])) {
                end--;
            } else if (target == (numbers[start] + numbers[end])){
                return new int[]{start + 1,end + 1};
            }
        }
        return new int[]{-1,-1};
    }
}
