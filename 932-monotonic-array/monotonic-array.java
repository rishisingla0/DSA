class Solution {
    public boolean isMonotonic(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                count++;
            }
        }

        int count2 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                count2++;
            }
        }

        if(count == nums.length-1 || count2 == nums.length-1) {
            return true;
        }
        return false;
    }
}