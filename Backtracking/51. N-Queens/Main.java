import java.util.*;

class Solution {
    private boolean isQueenSafe(int r,int c,boolean board[][])
    {
        int n = board.length;

        int [][] directions = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{-1,-1},{0,-1}};

        for(int rad=0; rad<n; rad++)
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
    private void NQueens(int r,int n,boolean board[][],List<List<String>> ans)
    {
        if(r == n)
        {
            ArrayList<String> z = adder(board);
            ans.add(z);
            return;
        }
        for(int col=0; col<n; col++)
        {
            if(isQueenSafe(r,col,board) == true)
            {
                board[r][col] = true;
                NQueens(r+1,n,board,ans);
                board[r][col] = false;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) 
    {
        List<List<String>> ans = new ArrayList<>();
        boolean board[][] = new boolean[n][n];
        NQueens(0,n,board,ans);
        return ans;
    }
    ArrayList<String> adder(boolean [][] board)
    {
        ArrayList<String> arr = new ArrayList<>();
        for(boolean [] r : board)
        {
            StringBuilder s = new StringBuilder();
            for(boolean ele : r)
            {
                if(ele)
                {
                    s.append("Q");
                }
                else
                {
                    s.append(".");
                }
            }
            arr.add(s.toString());
        }
        return arr;
    }
}