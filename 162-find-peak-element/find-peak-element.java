class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // Descending slope: a peak exists at mid or to the left
                right = mid;
            } else {
                // Ascending slope: a peak exists strictly to the right
                left = mid + 1;
            }
        }

        // left == right converges on a peak index
        return left;
    }
}