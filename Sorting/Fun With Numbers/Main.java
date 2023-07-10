import java.util.*;

class Solution {
    public int[] CountRounds(int[] arr, int[][] queries) {
        // Write your code here.
		int n = arr.length;
		int m = queries.length;
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0; i < n; i++)
		{
			al.add(arr[i]);
		}

		int []position = new int[n+2];

		position[0] = 0;
		position[n+1] = n+1;

		for(int i = 0; i < n; i++)
		{
			position[arr[i]] = i+1;
		}

		int count = 1;

		for(int i = 2; i <= n; i++)
		{
			if(position[i] < position[i-1]) count++;
		}

		int ans[] = new int[m];
		for(int i = 0; i < m; i++)
		{
			int q_f_val = queries[i][0];
			int q_s_val = queries[i][1];

			int f_val = al.get(q_f_val - 1);
			int s_val = al.get(q_s_val - 1);

			if(position[f_val - 1] > position[f_val])count--;

			if(position[f_val] > position[f_val + 1])count--;

			if(s_val - 1 != f_val && position[s_val - 1] > position[s_val])count--;

			if(s_val + 1 != f_val && position[s_val] > position[s_val + 1])count--;

			position[f_val] = q_s_val;
			position[s_val] = q_f_val;

			int temp = al.get(q_f_val - 1);
			al.set(q_f_val - 1,al.get(q_s_val - 1));
			al.set(q_s_val - 1,temp);

			if(position[f_val - 1] > position[f_val])count++;

			if(position[f_val] > position[f_val + 1])count++;

			if(s_val - 1 != f_val && position[s_val - 1] > position[s_val])count++;

			if(s_val + 1 != f_val && position[s_val] > position[s_val + 1])count++;

			ans[i] = count;
		}

		return  ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int[][] queries = new int[m][2];
        for(int i = 0; i< m; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }
        sc.close();
        Solution Obj = new Solution();
        int[] ans = Obj.CountRounds(arr, queries);

        for(int a: ans)
            System.out.println(a);
    }
}