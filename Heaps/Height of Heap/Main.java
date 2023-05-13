import java.util.*;
 class Accio{
    int HeightOfHeap(int n,int[] arr){
        //write code here.
		int height = 0;
		while(n != 1)
		{
			n /= 2;
			height++;
		}
		return height;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;++i){
            arr[i] = sc.nextInt();
        }
        sc.close();
        Accio obj = new Accio();
        int ans=obj.HeightOfHeap(n,arr);
        System.out.println(ans);
    }
}
