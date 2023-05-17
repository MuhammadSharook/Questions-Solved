import java.util.*;
class Solution{
	private int findKthLargest(int []arr,int n,int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<n; i++)
		{
			pq.add(arr[i]);

			if(pq.size() > k)
			{
				pq.remove();
			}
		}
		return pq.peek();
	}
	private int findKthSmallest(int []arr,int n,int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<n; i++)
		{
			pq.add(arr[i]);

			if(pq.size() > k)
			{
				pq.remove();
			}
		}
		return pq.peek();
	}
    public void kSmallLarge( int arr [], int n, int k){
       //Write your code and print here.
		int a = findKthSmallest(arr,n,k);

		int b = findKthLargest(arr,n,k);

		System.out.println(a);
		System.out.println(b);
    }
}
public class Main{
   public static void main(String args[]){
      
      int n;
      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();
      int arr[]=new int[n]; 
      for(int i=0; i<n; i++){
         arr[i]=sc.nextInt();
      }

      int k; 
      k=sc.nextInt(); 
      sc.close();
      Solution obj= new Solution();
      obj.kSmallLarge(arr,n, k);


   }
}