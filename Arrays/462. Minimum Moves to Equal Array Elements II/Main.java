import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) 
    {
        int minOp = 0;
        Arrays.sort(nums);
        int mid = nums[nums.length/2];
        for(int i : nums)
        {
            minOp += Math.abs(i - mid);
        }
        return minOp;
    }
}