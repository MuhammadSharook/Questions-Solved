// package Heaps.Build Max Heap;

import java.util.*;

class Solution {
    boolean checkHeap(int arr[]) {
        int n = arr.length;
        for (int i = 0; i <= (n - 2) / 2; i++) {
            if (arr[2 * i + 1] > arr[i]) {
                return false;
            }

            if (2 * i + 2 < n && arr[2 * i + 2] > arr[i]) {
                return false;
            }
        }
        return true;
    }

	void swap(int []data,int i,int j)
	{
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	void upHeapify(int []data,int ci)
	{
		int pi = (ci - 1)/2;

		if(pi >= 0 && data[pi] < data[ci])
		{
			swap(data,pi,ci);
			upHeapify(data,pi);
		}
	}
    void buildHeap(int arr[]) {
        //Write code here.
		for(int i = 0; i < arr.length; i++)
		{
			upHeapify(arr,i);
		}
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Obj.buildHeap(arr);
        if (Obj.checkHeap(arr)) {
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect");
        }
        sc.close();
    }
}
