class Solution {
    public boolean isValidSudoku(char[][] board) {
       boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] square = new boolean[9][9];

        for (int r = 0; r < 9; r++){
            for (int c = 0; c < 9; c++){
                char curr = board[r][c];
                if (curr == '.') continue;

                int d = curr - '1'; 
                int s = (r / 3) * 3 + (c / 3);

                if (rows[r][d] == true || cols[c][d] == true || square[s][d] == true) return false;

                rows[r][d] = true;
                cols[c][d] = true;
                square[s][d] = true;
            }
        }
        return true;
    }
}
