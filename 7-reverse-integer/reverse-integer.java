class Solution {
    public int reverse(int x) {
        long reversed = 0;
        
        while (x != 0) {
            reversed = reversed * 10 + (x % 10);
            x /= 10;
        }
        
        // Cast to int if it fits in 32-bit signed integer range, otherwise return 0
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }
        
        return (int) reversed;
    }
}