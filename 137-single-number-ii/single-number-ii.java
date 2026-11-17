class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for (int num : nums) {
            // Add bits appearing for the 1st time, remove if already in 'twos'
            ones = (ones ^ num) & ~twos;
            // Add bits appearing for the 2nd time, remove if now in 'ones'
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }
}