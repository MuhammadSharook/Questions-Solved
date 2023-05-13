package Heaps.HeapSort;
import java.util.*;
class Solution {
	void swap(int []data,int i,int j)// basic swap ope.
	{
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	void downHeapify(int []data,int pi,int n)
	{
		int maxi = pi;
		int lci = 2 * pi + 1;// ind of left child 
		int rci = 2 * pi + 2;// ind of right child
		if(lci < n && data[lci] > data[maxi])
		{
			maxi = lci;
		}
		if(rci < n && data[rci] > data[maxi])
		{
			maxi = rci;
		}
		if(maxi != pi)//if maxi is changed the only we again do swap & downheapify.
		{
			swap(data,maxi,pi);
			downHeapify(data,maxi,n);
		}
	}
    void heapSort(int arr[], int n)
    {
        // write code here.
		// 1-> creating MAX Heap.
		for(int i = n/2-1; i >= 0; i--)
		{
			downHeapify(arr,i,n);
		}
		// 2-> swap the max ele to the end,
		// & end min ele will be shifted to the 0th ind.
		for(int i = n-1; i >= 0; i--)
		{
			swap(arr,0,i);
			downHeapify(arr,0,i);
		}
    }
	
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
		
		sc.close();
        Solution Obj = new Solution();
        Obj.heapSort(arr1, n);
        for(int i=0;i<n;i++){
            System.out.print(arr1[i] + " ");
        }
    }
}