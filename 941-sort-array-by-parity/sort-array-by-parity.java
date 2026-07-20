class Solution {
    public int[] sortArrayByParity(int[] nums) {

        int lb = 0;
        int ub = nums.length - 1;

        while (lb < ub) {

            while (lb < ub && nums[lb] % 2 == 0) {
                lb++;
            }

            while (lb < ub && nums[ub] % 2 != 0) {
                ub--;
            }

            if (lb < ub) {
                int temp = nums[lb];
                nums[lb] = nums[ub];
                nums[ub] = temp;
            }
        }

        return nums;
    }
}