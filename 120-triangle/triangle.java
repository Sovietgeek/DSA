class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1]; // Extra slot prevents out-of-bounds on the last row
        
        // Start from the bottom row and move upwards
        for (int row = n - 1; row >= 0; row--) {
            List<Integer> currentRow = triangle.get(row);
            for (int col = 0; col <= row; col++) {
                // Minimum path sum from (row, col) is its value + min of its two adjacent children below
                dp[col] = currentRow.get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }
        
        return dp[0];
    }
}