class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1, c2 = cost2, c3 = costBoth;
        long n1 = need1, n2 = need2;
        
        long common = Math.min(n1, n2);
        
        return common * Math.min(c3, c1 + c2) 
             + (n1 - common) * Math.min(c1, c3) 
             + (n2 - common) * Math.min(c2, c3);
    }
}