import java.util.*;

class Solution{
	static int solve(int a[],int n,int k)
	{
	    //Write your code here.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int A : a)
		{
			pq.add(A);
		}
		int op = 0;
		while(pq.size() > 0)
		{
			if(pq.peek() >= k)return op;

			int c1 = pq.remove();
			int c2 = pq.remove();

			int newSweetness = 1 * c1 + 2 * c2;
			pq.add(newSweetness);
			op++;
		}
		if(pq.peek() < k)return -1;

		return op;
	}
}
public class Main {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }   
        input.close();
        System.out.println(Solution.solve(a,n,k));
    }
}