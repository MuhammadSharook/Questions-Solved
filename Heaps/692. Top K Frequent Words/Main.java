import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) 
    {
        HashMap<String,Integer> map = new HashMap<>();
        for(String w : words)
        {
            map.put(w,map.getOrDefault(w,0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((String t,String o) ->
        {
            return map.get(t) == map.get(o) ? o.compareTo(t) : map.get(t) - map.get(o);
        });
        for(String key : map.keySet())
        {
            pq.add(key);

            if(pq.size() > k)
            {
                pq.remove();
            }
        }
        List<String> ans = new ArrayList<>();
        while(pq.size() > 0)
        {
            ans.add(pq.remove());
        }
        Collections.reverse(ans);
        return ans;
    }
}