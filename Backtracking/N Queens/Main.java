import java.util.*;

public class Main {
	private static boolean isQueenSafe(int r,int c,boolean board[][])
	{
		int n = board.length;

		int [][] directions = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{-1,-1},{0,-1}};

		for(int rad=1; rad<n; rad++)
		{
			for(int []d : directions)
			{
				int i = r + rad * d[0];
				int j = c + rad * d[1];

				if(i>=0 && j>=0 && i<n && j<n && board[i][j] == true) return false;
			}
		}
		return true;
	}
	private static int Nqueens(int r,int n,boolean board[][])
	{
		if(r == n)
		{
			return 1;
		}
		int out = 0;
		for(int c=0; c<n; c++)
		{
			if(isQueenSafe(r,c,board) == true)
			{
				board[r][c] = true;
				out = out + Nqueens(r+1,n,board);
				board[r][c] = false;
			}
		}
		return out;
	}
    public static int totalNQueens(int n) 
	{
        // write code here.
		boolean board[][] = new boolean[n][n];
		return Nqueens(0,n,board);
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    
        sc.close();
        System.out.println(totalNQueens(n));
    }
}