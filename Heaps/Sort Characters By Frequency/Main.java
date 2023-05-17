import java.util.*;

class Pair implements Comparable<Pair>
{
	int val;
	char ch;
	Pair(int val,char ch)
	{
		this.val = val;
		this.ch = ch;
	}
	public int compareTo(Pair other)
	{
		return other.val == this.val ? other.ch - this.ch : other.val - this.val;
	}
}

class Solution {
    public String frequencySort(String s) {
        //Write code here.
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i=0; i<s.length(); i++)
		{
			char ch = s.charAt(i);
			map.put(ch,map.getOrDefault(ch,0)+1);
		}

		ArrayList<Character> keys = new ArrayList<>(map.keySet());

		PriorityQueue<Pair> pq = new PriorityQueue<>();

		for(char c : keys)
		{
			pq.add(new Pair(map.get(c),c));
		}
		StringBuilder ans = new StringBuilder();
		while(pq.size() > 0)
		{
			Pair rpair = pq.remove();
			int fre = rpair.val;
			char c = rpair.ch;
			while(fre-- >0)
			{
				ans.append(c);
			}
		}
		return ans.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Solution Obj = new Solution();
        String result = Obj.frequencySort(s);
        System.out.println(result);
        sc.close();
    }
}