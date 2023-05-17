import java.util.*;

class Solution {
    public String frequencySort(String s) 
    {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        ArrayList<Character> keys = new ArrayList<>(map.keySet());

        PriorityQueue<Character> pq = new PriorityQueue<>((Character a, Character b) ->
        {
            return map.get(b) - map.get(a);
        });
        for(char c : keys)
        {
            pq.add(c);
        }

        StringBuilder ans = new StringBuilder();
        while(pq.size() > 0)
        {
            char c = pq.remove();
            int freq = map.get(c);
            while(freq-- > 0)
            {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}