
public class Main {
	
	static boolean checkSolution(int grid[][]){
	    int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;
        int dire[][] = new int [][]{{2,1},{1,2},{-2,-1},{-1,-2},{-2,1},{-1,2},{2,-1},{1,-2}};
        return fun1(grid,vis,dire,0,0,1);
	}
	private static boolean fun1(int [][]grid,boolean [][]vis,int dire[][],int r,int c,int move)
    {
        int n = grid.length;
        if(move == n * n)
        {
            return true;
        }

        for(int []d : dire)
        {
            int newR = r + d[0];
            int newC = c + d[1];
            if(newR >=0 && newR < n && newC >= 0 && newC < n && vis[newR][newC] == false && grid[newR][newC] == move)
            {
                vis[newR][newC] = true;
                if(fun1(grid,vis,dire,newR,newC,move+1))
                {
                    return true;
                }
                vis[newR][newC] = false;
            }
        }
        return false;
    }
	static boolean fun(int [][]arr,int dire[][],int r,int c,int move)
	{
		int n = arr.length;
		if(r < 0 || c < 0 || r >= n || c >= n || arr[r][c] > -1)
		{
			return false;
		}
		if(move == n * n)
		{
			return true;
		}
		for(int [] d : dire)
		{
			int newR = r + d[0];
			int newC = c + d[1];
			if(newR >=0 && newR < n && newC >= 0 && newC < n && arr[newR][newC] == -1)
			{
				arr[newR][newC] = move;
				if(fun(arr,dire,newR,newC,move+1))
				{
					return true;
				}
				else
				{
					arr[newR][newC] = -1;
				}
			}
		}
		return false;
	}
	static int[][] findPath()
	{
		// write code here.
		int arr[][] = new int[8][8];
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				arr[i][j] = -1;
			}
		}
		arr[0][0] = 0;
		int dire[][] = new int [][]{{2,1},{1,2},{-2,-1},{-1,-2},{-2,1},{-1,2},{2,-1},{1,-2}};
		if(fun(arr,dire,0,0,1))
		{
			return arr;
		}
		else
		{
			return new int[][]{{}};
		}
	}
	
    public static void main(String[] args) {
        int[][] ans = findPath();
        if(checkSolution(ans)){
            System.out.print("1");
        }
        else{
            System.out.print("0");
        }
    }
}