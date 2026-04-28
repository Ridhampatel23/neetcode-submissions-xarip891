class NumMatrix {
    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Create prefix sum grid (one extra row/col for easier calculation)
        prefixSum = new int[rows + 1][cols + 1];
        
        // cell by cell
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                prefixSum[r + 1][c + 1] = 
                    matrix[r][c] +           // current cell
                    prefixSum[r][c + 1] +    // everything above (adds top left corner as well)
                    prefixSum[r + 1][c] -    // everything left (adds top left corner as well)
                    prefixSum[r][c];         // subtract corner (counted twice)
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2 + 1][col2 + 1]     // full rectangle
             - prefixSum[row1][col2 + 1]         // minus above (removes top left corner as well)
             - prefixSum[row2 + 1][col1]         // minus left (removes top left corner as well)
             + prefixSum[row1][col1];            // plus top left corner (removed twice)
    }
}