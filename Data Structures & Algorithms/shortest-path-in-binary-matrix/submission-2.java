class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        if (grid[0][0] == 1 || grid[ROWS - 1][COLS - 1] == 1) return -1;

        int[][] visited = new int[ROWS][COLS];
        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[2]);
        grid[0][0] = 1;

        int length = 1;
        while (!queue.isEmpty()){
            int qLength = queue.size();
            for (int i = 0; i < qLength; i++){
                int[] cell = queue.pop();
                int r = cell[0];
                int c = cell[1];
                if (r == ROWS - 1 && c == COLS - 1) {
                    return length;
                }    

                int[][] directions = {{r, c + 1}, {r, c - 1}, {r + 1, c}, {r - 1, c}, {r + 1, c + 1}, {r - 1, c - 1}, {r + 1, c - 1}, {r - 1, c + 1}};

                for (int j = 0; j < 8; j++){
                    int newR = directions[j][0], newC = directions[j][1];
                    if (newR < 0 || newC < 0 || newR == ROWS || newC == COLS || grid[newR][newC] == 1)
                        continue;
                    
                    queue.add(directions[j]);
                    grid[newR][newC] = 1;
                }
            }
            length++;
        }
          
          return -1; // This should never be called unless a path don't exist
    }
}