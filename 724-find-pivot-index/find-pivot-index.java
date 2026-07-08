class Solution {
    public int pivotIndex(int[] nums) {
        int n =nums.length;
        int [] prefix = new int [n+1];
        prefix[0] =0;
        for(int i=0;i<n;i++){
            
            prefix[i+1] = prefix[i]+nums[i];
            
        }

        for(int i=0;i<n;i++){
            int pivot =nums[i];
            int leftsum=prefix[i];
            int totalsum = prefix[n];
            int rightsum = totalsum-leftsum-pivot;
            if(leftsum==rightsum){
                return i;
            }
        }
        return -1;
    }
}