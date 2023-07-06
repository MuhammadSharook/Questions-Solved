import java.util.Scanner;

public abstract class Main {
    private static void conquer(int []arr,int si,int mid,int ei)
    {
        int []temp = new int[ei - si + 1];
        int ind1 = si;
        int ind2 = mid+1;
        int x = 0;
        while(ind1 <= mid && ind2 <= ei)
        {
            if(arr[ind1] <= arr[ind2])
            {
                temp[x] = arr[ind1];
                x++;
                ind1++;
            }
            else
            {
                temp[x] = arr[ind2];
                x++;
                ind2++;
            }
        }

        while(ind1 <= mid)
        {
            temp[x++] = arr[ind1++];
        }

        while(ind2 <= ei)
        {
            temp[x++] = arr[ind2++];
        }

        for(int i = 0, j = si; i < temp.length; i++,j++)
        {
            arr[j] = temp[i];
        }
    }
    private static void divide(int []arr,int si,int ei)
    {
        if(si >= ei)
        {
            return;
        }
        int mid = si + (ei - si)/2;
        divide(arr, si, mid);
        divide(arr, mid+1, ei);
        conquer(arr,si,mid,ei);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i = 0 ; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        sc.close();

        divide(arr,0,n-1);

        for(int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
