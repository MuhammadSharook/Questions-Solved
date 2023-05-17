import java.util.*;

class Solution {
    void concatArray(int arr[], int n)
    {
        // write code here
        int out [] = new int[2*n];
        int position = 0;
        for(int i = 0;i < 2;i++)
        {
            for(int j =0;j < n;j++)
            {
                out[position] = arr[j];
                position++;
            }
        }
        for(int  i = 0;i < 2*n;i++)
        {
            System.out.print(out[i] + " ");
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
        Obj.concatArray(arr1, n);
    }
}