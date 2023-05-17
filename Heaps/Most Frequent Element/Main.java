import java.util.*;

class Solution {
    public int[] KMostFrequentElements(int[] arr, int k) {
        // Write your code here.
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i : arr)
		{
			map.put(i,map.getOrDefault(i,0)+1);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> 
		{
			return map.get(a) == map.get(b) ? map.get(b) - map.get(a) : map.get(a) - map.get(b);
		});

		for(int key : map.keySet())
		{
			pq.add(key);
			if(pq.size() > k)
			{
				pq.remove();
			}
		}

		int ans[] = new int[k];
		for(int i=0; i<k; i++)
		{
			ans[i] = pq.remove();
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();
	    Solution Obj = new Solution();
        int[] ans = Obj.KMostFrequentElements(arr, k);
        Arrays.sort(ans);
        for(int a : ans)
            System.out.print(a + " ");
    }
}