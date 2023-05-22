import java.util.*;

class Solution {
    private boolean isValid(int i,int j,int n)
    {
        if(i < 0 || j < 0 || i >= n || j >= n)
        {
            return false;
        }
        return true;
    }
    private void formGraph(int[][] grid,int x,int y,int n,Queue<int []>q,boolean [][]vis,int []dirX,int []dirY)
    {
        if(isValid(x,y,n) == false)
        {
            return;
        }
        if(vis[x][y] == false && grid[x][y] == 1)
        {
            q.add(new int[]{x,y});
        }
        else
        {
            return;
        }

        vis[x][y] = true;

        for(int i = 0; i < 4; i++)
        {
            int newX = x + dirX[i];
            int newY = y + dirY[i];
            formGraph(grid,newX,newY,n,q,vis,dirX,dirY);
        }
    }
    public int shortestBridge(int[][] grid) 
    {
        Queue<int []> q = new LinkedList<>();
        int []dirX = {-1,0,1,0};
        int []dirY = {0,-1,0,1};
        int n = grid.length;
        boolean [][]vis = new boolean[n][n];
        boolean breakEnable = false;
        for(int i = 0; i < n; i++)
        {
            if(breakEnable)break;
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                {
                    formGraph(grid,i,j,n,q,vis,dirX,dirY);
                    breakEnable = true;
                    break;
                }
            }
        }
        int minSteps = 0;
        while(q.size() > 0)
        {
            int size = q.size();
            while(size-- > 0)
            {
                int[]curr = q.remove();
                for(int i = 0; i < 4; i++)
                {
                    int newX = curr[0] + dirX[i];
                    int newY = curr[1] + dirY[i];
                    if(isValid(newX,newY,n))
                    {
                        if(vis[newX][newY] == false && grid[newX][newY] == 0)
                        {
                            q.add(new int[]{newX,newY});
                            vis[newX][newY] = true;
                        }
                        else if(vis[newX][newY] == false && grid[newX][newY] == 1)
                        {
                            return minSteps;
                        }
                    }
                }
            }
            minSteps++;
        }
        return -1;
    }
}