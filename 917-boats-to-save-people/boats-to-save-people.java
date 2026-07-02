class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;

        int count = 0;
        int sum = 0;
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            sum = people[i] + people[j];
            if (sum <= limit) {
               
                i++;
            } 
            j--;
            count++;
               

            
        }return count;

}}