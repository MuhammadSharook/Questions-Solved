import java.util.*;

public class Main {
    private static void selectionsort(int []arr,int n)
    {
        for(int i = 0; i < n; i++)
        {
            int smallest = i;
            for(int j = i+1; j < n; j++)
            {
                if(arr[j] > arr[smallest])
                {
                    smallest = j;
                }
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }

        for(int i = 0; i < n; i ++)
        {
            System.out.print(arr[i] +  " ");
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
        sc.close();
        selectionsort(arr,n);
    }
}
