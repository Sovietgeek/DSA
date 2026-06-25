class Solution {
    public int thirdMax(int[] nums) {

        Long first = Long.MIN_VALUE;
        Long second = Long.MIN_VALUE;
        Long third = Long.MIN_VALUE;

        for (int num : nums) {

            // Duplicate values skip karo
            if (num == first || num == second || num == third) {
                continue;
            }

            if (num > first) {
                third = second;
                second = first;
                first = (long) num;
            } 
            else if (num > second) {
                third = second;
                second = (long) num;
            } 
            else if (num > third) {
                third = (long) num;
            }
        }

        // Agar third maximum nahi mila to first return karo
        return third == Long.MIN_VALUE ? first.intValue() : third.intValue();
    }
}