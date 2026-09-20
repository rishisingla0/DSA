class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int target = nums[nums.length/2];
        for(int i=0; i<nums.length; i++) {
            if(i == nums.length/2) {
                continue;
            }
            if(nums[i] == target) {
                return false;
            }
        }
        return true;
    }
}