import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) 
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->
        {
            return map.get(a) == map.get(b) ? b - a : map.get(a) - map.get(b);
        });

        for(int i : map.keySet())
        {
            pq.add(i);
            if(pq.size() > k)
            {
                pq.remove();
            }
        }
        int []ans = new int[k];
        int i = 0;
        while(pq.size() > 0)
        {
            ans[i++] = pq.remove();
        }
        return ans;
    }
}