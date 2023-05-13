import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

	private void swap(int i,int j)
	{
		int valAtI = data.get(i);
		int valAtJ = data.get(j);

		data.set(i,valAtJ);
		data.set(j,valAtI);
	}
	private void upHeapify(int ci)
	{
		
		int pi = (ci - 1)/2;
		if(pi >= 0 && data.get(pi) > data.get(ci))
		{
			swap(ci,pi);
			upHeapify(pi);
		}
	}
    public void add(int val) {
      // write your code here.
		data.add(val);
		upHeapify(data.size()-1);
    }

	private void downHeapify(int pi)
	{
		int mini = pi;
		
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		if(lci < data.size() && data.get(lci) < data.get(mini))
		{
			mini = lci;
		}
		if(rci < data.size() && data.get(rci) < data.get(mini))
		{
			mini = rci;
		}
		if(mini != pi)
		{
			swap(pi,mini);
			downHeapify(mini);
		}
	}
    public int remove() {
      // write your code here.
		if(data.size() == 0)
		{
			System.out.println("Underflow");
			return -1;
		}
		swap(0,data.size()-1);
		int ele = data.remove(data.size()-1);
		downHeapify(0);
		return ele;
    }

    public int peek() {
      // write your code here.
		if(data.size() == 0)
		{
			System.out.println("Underflow");
			return -1;
		}
		return data.get(0);
    }

    public int size() {
      // write your code here.
		return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}