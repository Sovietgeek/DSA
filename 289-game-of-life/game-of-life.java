class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int liveNeighbors = 0;
                
                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        if (board[nr][nc] == 1 || board[nr][nc] == 2) {
                            liveNeighbors++;
                        }
                    }
                }
                
                if (board[r][c] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[r][c] = 2;
                } else if (board[r][c] == 0 && liveNeighbors == 3) {
                    board[r][c] = 3;
                }
            }
        }
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 2) {
                    board[r][c] = 0;
                } else if (board[r][c] == 3) {
                    board[r][c] = 1;
                }
            }
        }
    }
}