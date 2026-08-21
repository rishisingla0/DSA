class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            int currentMax = Math.max(
                num,
                Math.max(maxProduct * num, minProduct * num)
            );

            int currentMin = Math.min(
                num,
                Math.min(maxProduct * num, minProduct * num)
            );

            maxProduct = currentMax;
            minProduct = currentMin;

            answer = Math.max(answer, maxProduct);
        }

        return answer;
    }
}