import java.util.*;

public class Main {
    private static int partition(int []arr,int lo,int hi)
    {
        int pivot = arr[hi];
        int i = lo-1;
        for(int j = lo; j < hi; j++)
        {
            if(arr[j] < pivot)
            {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i] = arr[hi];
        arr[hi] = temp;

        return i+1;
    }
    private static void QuickSort(int []arr,int lo,int hi)
    {
        if(lo < hi)
        {
            int pind = partition(arr,lo,hi);

            QuickSort(arr, lo, pind);
            QuickSort(arr, pind+1, hi);
        }
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int  i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        QuickSort(arr,0,n-1);
        sc.close();
    }
}
