class Solution {
    public boolean checkValidGrid(int[][] grid) 
    {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;
        int dire[][] = new int [][]{{2,1},{1,2},{-2,-1},{-1,-2},{-2,1},{-1,2},{2,-1},{1,-2}};
        return fun(grid,vis,dire,0,0,1);
    }
    private boolean fun(int [][]grid,boolean [][]vis,int dire[][],int r,int c,int move)
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
                if(fun(grid,vis,dire,newR,newC,move+1))
                {
                    return true;
                }
                vis[newR][newC] = false;
            }
        }
        return false;
    }
}