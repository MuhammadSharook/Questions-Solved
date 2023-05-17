class Solution {
    public int[] shuffle(int[] nums, int n) 
    {
        int sp1 = 0;
        int sp2 = n;
        int ep1 = n;
        int ep2 = 2*n;
        int ans[] = new int[nums.length];
        int i = 0;
        while(sp1 < ep1 && sp2 < ep2)
        {
            ans[i++] = nums[sp1++];
            ans[i++] = nums[sp2++];
        }
        return ans;
    }
}