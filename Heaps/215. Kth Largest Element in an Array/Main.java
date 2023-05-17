import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k)
    {
        // Arrays.sort(nums);
        // return nums[nums.length - k];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<nums.length; i++)
        {
            pq.add(nums[i]);
        }
        while(pq.size() > 0 && k-- > 1)
        {
            pq.remove();
        }
        return pq.peek();
    }
}