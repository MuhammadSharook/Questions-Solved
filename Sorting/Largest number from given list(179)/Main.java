import java.util.*;

class Solution1 {
    public String largestNumber(int[] nums) 
    {
        String []str = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str,(a,b) -> (b+a).compareTo(a+b));

        if(str[0].equals("0"))
        {
            return "0";
        }
        String s = new String();
        for(String x : str)
        {
            s += x;
        }

        return s;
    }
}
class Solution {
	private static class LargenumComparator implements Comparator<String>
	{
		public int compare(String a,String b)
		{
			String x = a + b;
			String y = b + a;
			return y.compareTo(x);
		}
	}
    void largestNumber(String a[], int n)
    {
        //Write your code here.

		Arrays.sort(a,new LargenumComparator());

		if(a[0].equals("0"))
		{
			System.out.print(0);
			return;
		}

		// String str = new String();
		for(String s : a)
		{
			// str += s;
			System.out.print(s);
		}
		// System.out.print(str);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        String a[] = new String[n];

        for(int i = 0; i < n; i++){
            a[i] = input.next();
        }
        input.close();
        Solution Obj = new Solution();
        Obj.largestNumber(a,n);
    }
}