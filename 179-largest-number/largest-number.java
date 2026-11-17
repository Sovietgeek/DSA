import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // Sort strings so that (b + a) comes before (a + b) if (b + a) is larger
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: if the largest number is "0", the entire array consists of zeros
        if (strs[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }

        return sb.toString();
    }
}