class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<nums.length; i++) {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ans[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.push(i);
        }

        for(int i=0; i<nums.length; i++) {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ans[stack.peek()] = nums[i];
                stack.pop();
            }
        }

        for(int i : stack) {
            ans[i] = -1;
        }

        return ans;
    }
}