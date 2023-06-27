class Solution {
    public boolean possible(int [] weights,int mid,int days)
    {
        int no_days = 1;
        int weightOfThisDay = 0;
        for(int w : weights)
        {
            if(weightOfThisDay + w <= mid)
            {
                weightOfThisDay += w;
            }
            else
            {
                no_days++;
                weightOfThisDay = w;
            }
        }
        return no_days <= days;
    }
    public int shipWithinDays(int[] weights, int days) 
    {
        int si = 0;
        int ei = 0;
        for(int w : weights)
        {
            si = Math.max(si,w);
            ei += w;
        }
        int pans = -1;
        while(si <= ei)
        {
            int mid = (si + ei) / 2;
            if(possible(weights,mid,days) == true)
            {
                pans = mid;
                ei = mid - 1;
            }
            else
            {
                si = mid + 1;
            }
        }
        return pans;
    }
}