class Solution {
    public boolean isPowerOfFour(int n) {
        // Agar n <= 0 hai toh woh kabhi power of four nahi ho sakta
        if (n <= 0) return false;

        // Hum check kar rahe hain ki kya n ko 4 se log lene par round number aata hai
        int x = (int) (Math.log(n) / Math.log(4));
        
        // Agar 4 ki power x wapas n ke barabar hai, toh true, nahi toh false
        return Math.pow(4, x) == n;
    }
}