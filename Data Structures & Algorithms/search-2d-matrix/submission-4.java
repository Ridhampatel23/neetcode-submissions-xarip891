class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            int max = 0;
            for (int n : matrix[mid]){
                if (n == target) return true;
                max = Math.max(max, n); 
            }
            if (max < target) left = mid + 1;
            else if (max > target) right = mid - 1;
        }
        return false;
    }
}
