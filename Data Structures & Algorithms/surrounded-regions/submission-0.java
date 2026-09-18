class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

       for (int r = 0; r < ROWS; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0);
            }
            if (board[r][COLS - 1] == 'O') {
                dfs(board, r, COLS - 1);
            }
        }

        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c);
            }
            if (board[ROWS - 1][c] == 'O') {
                dfs(board, ROWS - 1, c);
            }
        }
        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                if (board[r][c] == 'O') board[r][c] = 'X';
                else if (board[r][c] == '#') board[r][c] = 'O';
            }
        }    
    }

    public void dfs(char[][] board, int r, int c){
        if (r < 0 || c < 0 || r > board.length - 1 
                            || c > board[0].length - 1) return;

        if (board[r][c] == '#' || board[r][c] == 'X') return;

        board[r][c] = '#';

        int[][] DIRS ={{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] dir : DIRS){
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(board, nr, nc);
        } 
    }
}
