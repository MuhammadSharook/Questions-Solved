class Solution {
    private boolean isPossible(int n,int []arr,long mid)
    {
        long currSum = 0;
        long tar = mid * n;
        for(int i : arr)
        {
            if(i < mid)
            {
                currSum += i;
            }
            else
            {
                currSum += mid;
            }
        }

        return currSum >= tar;
    }
    public long maxRunTime(int n, int[] batteries) 
    {
        long sumBat = 0;
        for(int i : batteries){
            sumBat += i;
        }
        long st = 0;
        long en = sumBat / n;
        long ans = 0;

        while(st <= en)
        {
            long mid = (st + en) / 2;

            if(isPossible(n,batteries,mid))
            {
                ans = mid;
                st = mid+1;
            }
            else
            {
                en = mid - 1;
            }
        }

        return ans;
    }
}