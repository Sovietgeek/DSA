import java.util.Arrays;

class Solution {
    public int maxProduct(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        Arrays.sort(digits);

        int left = digits.length - 2;  // Second largest digit pointer
        int right = digits.length - 1; // Largest digit pointer

        return (digits[left] - '0') * (digits[right] - '0');
    }
}