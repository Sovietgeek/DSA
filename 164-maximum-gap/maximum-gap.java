class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) return 0;

        int n = nums.length;
        int bucketSize = (int) Math.ceil((double) (max - min) / (n - 1));
        int[] minBucket = new int[n - 1];
        int[] maxBucket = new int[n - 1];

        java.util.Arrays.fill(minBucket, Integer.MAX_VALUE);
        java.util.Arrays.fill(maxBucket, Integer.MIN_VALUE);

        for (int num : nums) {
            if (num == min || num == max) continue;
            int idx = (num - min) / bucketSize;
            minBucket[idx] = Math.min(minBucket[idx], num);
            maxBucket[idx] = Math.max(maxBucket[idx], num);
        }

        int maxGap = 0;
        int previous = min;

        for (int i = 0; i < n - 1; i++) {
            if (minBucket[i] == Integer.MAX_VALUE) continue;
            maxGap = Math.max(maxGap, minBucket[i] - previous);
            previous = maxBucket[i];
        }

        return Math.max(maxGap, max - previous);
    }
}