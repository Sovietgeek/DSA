class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int k = 2; // Write pointer for the next valid position

        for (int i = 2; i < nums.length; i++) {
            // Keep nums[i] only if it differs from the element two slots back
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}