import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), k = sc.nextInt();
    int[] lifetime = new int[k];
    for (int i = 0; i < k; i++) lifetime[i] = sc.nextInt();
    sc.close();
    System.out.println(maxRunTime(n, lifetime));
  }



	private static boolean isPossible(int n,int[]arr,long x)
	{
		long currsum = 0;
		long tar = n * x;

		for(int i : arr)
		{
			if(i < x)
			{
				currsum += i;
			}
			else
			{
				currsum += x;
			}

			if(currsum >= tar)
			{
				return true;
			}
		}
		return currsum >= tar;
	}
  public static long maxRunTime(int n, int[] lifetime) {
    // your code here.

	  long lifesum = 0;
	  for(int i : lifetime)
	  {
		  lifesum += i;
	  }

	  long si = 0;
	  long ei = lifesum / n;
	  long ans = -1;


	  while(si <= ei)
	  {
		  long mid = (si + ei)/2;
		  if(isPossible(n,lifetime,mid))
		  {
			  ans = mid;
			  si = mid + 1;
		  }
		  else
		  {
			  ei = mid - 1;
		  }
	  }

	  return ans;
  }
}