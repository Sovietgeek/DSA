class NumMatrix {
    private int[][] prefix; // Class level pe isko declare karna zaroori hai
    
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        prefix = new int[rows + 1][cols + 1]; // +1 size for zero padding
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                prefix[i + 1][j + 1] = matrix[i][j] 
                                      + prefix[i][j + 1] 
                                      + prefix[i + 1][j] 
                                      - prefix[i][j];
            }
        }
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        return prefix[r2 + 1][c2 + 1] 
             - prefix[r1][c2 + 1] 
             - prefix[r2 + 1][c1] 
             + prefix[r1][c1];
    }
}