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

        for (int r = 0; r < 9; r++){
            for (int c = 0; c < 9; c++){
                if (board[r][c] == '.') continue; // Skip empty cells

                // 1. NORMALIZATION:
                // Convert char '1'-'9' to int 0-8.
                // This ensures our bits stay within the first 9 positions.
                int d = board[r][c] - '1'; 

                // 2. THE SHIFT (CREATING THE MASK):
                // '1 << d' takes the number 1 (000...0001) and moves it 'd' places left.
                // It creates a "marker" or "lane" specifically for this digit.
                // Example: If digit is 3, d=2, mask = 1 << 2 = 000000100.
                //
                // IMPORTANT CAPACITY LIMIT:
                // An 'int' in Java is 32 bits. This logic works HERE because Sudoku 
                // only has 9 digits. If we had > 31 digits (like a 40x40 board):
                // - Shift 32 would "overflow" or "wrap around" (32 % 32 = 0).
                // - We would need a 'long' (64 bits) or a 'BitSet' / 'boolean[]'.
                int mask = 1 << d;

                // 3. BOX INDEX FORMULA:
                // Maps the 9x9 grid into 9 unique square IDs (0 to 8).
                int s = (r / 3) * 3 + (c / 3);

                // 4. THE CHECK (BITWISE AND):
                // (rows[r] & mask) checks if the bit at position 'd' is already 1.
                // This compares the "checklist" with our new "marker".
                // Result > 0 means the "lane" was already occupied (duplicate!).
                if ((rows[r] & mask) > 0 || (cols[c] & mask) > 0 || (square[s] & mask) > 0) {
                    return false; 
                }

                // 5. THE UPDATE (BITWISE OR):
                // '|= mask' flips the switch at position 'd' to 1 (ON).
                // This merges the current checklist state with the new marker.
                // It "marks" the number as seen without affecting other bits.
                rows[r] |= mask;
                cols[c] |= mask;
                square[s] |= mask;
            }
        }
        return true; 
    }
}
