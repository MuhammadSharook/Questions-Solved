import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    MedianFinder medianFinder = new MedianFinder();
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      String s = sc.next();
      if (s.equals("addNum")) medianFinder.addNum(sc.nextInt()); else if (
        s.equals("findMedian")
      ) System.out.println(medianFinder.findMedian());
    }
    sc.close();
  }
}

class MedianFinder {

  // your code here

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() 
    {
        // your code here
	    left = new PriorityQueue<>(Collections.reverseOrder());
	    right = new PriorityQueue<>();
    }

  public void addNum(int num) 
  {
        // your code here.
        if(left.size() == 0 || num <= left.peek())
        {
            left.add(num);
        }
        else
        {
            right.add(num);
        }

        int ls = left.size();
        int rs = right.size();

        if(ls - rs == 2)
        {
            right.add(left.remove());
        }
        else if(rs > ls)
        {
            left.add(right.remove());
        }
  }

  public double findMedian() {
    // your code here.
	  if(left.size() == right.size())
	  {
		  return (1.0 * left.peek() + right.peek() * 1.0) / (2.0);
	  }
	  else
	  {
		  return left.peek();
	  }
	  
  }
}







