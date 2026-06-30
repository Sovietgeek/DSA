class Solution {
    public int[] sortedSquares(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    
    int left = 0;           // Pointer 1 start pe
    int right = n - 1;      // Pointer 2 end pe
    
    // Result array ko piche se (n-1 se 0 tak) fill karenge
    for (int i = n - 1; i >= 0; i--) {
        int leftSquare = nums[left] * nums[left];
        int rightSquare = nums[right] * nums[right];
        
        // Kaunsa square bada hai?
        if (leftSquare > rightSquare) {
            result[i] = leftSquare;  // Left wala bada tha, toh usko result mein daalo
            left++;                  // Left pointer aage badho
        } else {
            result[i] = rightSquare; // Right wala bada ya equal tha, usko daalo
            right--;                 // Right pointer peeche aao
        }
    }
    
    
    return result;
    }
}