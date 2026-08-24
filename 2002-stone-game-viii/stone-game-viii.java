class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        // Step 1: In-place Prefix Sum calculate karo
        for (int i = 1; i < n; i++) {
            stones[i] += stones[i - 1];
        }

        // Base case: Aakhri index se start karo
        int ans = stones[n - 1];

        // Step 2: Right to left move karo (Index 1 tak, kyunki x > 1 stones remove karne hain)
        for (int i = n - 2; i >= 1; i--) {
            ans = Math.max(ans, stones[i] - ans);
        }

        return ans;
    }
}