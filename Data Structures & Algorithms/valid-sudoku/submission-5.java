class Solution { 
    /**
     * BIT MASKING CONCEPT: 
     * Instead of using a Boolean Array (boolean[]) or a HashSet to track seen numbers,
     * we use a single Integer (32 bits) as a "Checklist". 
     * Each bit position (0-8) represents a digit (1-9).
     * 
     * Why Bitmasking?
     * 1. Space: 1 Integer (4 bytes) replaces a boolean array or HashSet.
     * 2. Speed: Bitwise operations (&, |, <<) are performed directly by CPU hardware wires.
     */
    public boolean isValidSudoku(char[][] board) {
        // We need 9 checklists for rows, 9 for columns, and 9 for 3x3 squares.
        // Initially, all are 0 (Binary: 000000000... all switches OFF).
        int[] rows = new int[9]; 
        int[] cols = new int[9]; 
        int[] square = new int[9]; 

        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[r].length; c++){
                if (board[r][c] == '.') continue;
                int ch = board[r][c] - '1';

                

                int mask = 1 << ch;
                int s = (r / 3) * 3 + (c / 3);

                if ((rows[r] & mask) > 0 || (cols[c] & mask) > 0 || (square[s] & mask) > 0) return false;

                rows[r] |= mask;
                cols[c] |= mask;
                square[s] |= mask;
                 
            }
        }

        return true; 
    }
}
