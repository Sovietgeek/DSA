class Solution {
    
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        // ans[0] pehle se 0 hota hai
        for (int i = 1; i <= n; i++) {
            // i & (i - 1) karne se aakhri '1' bit hat jati hai
            ans[i] = ans[i & (i - 1)] + 1;
        }
        
        return ans;
    }

    
}