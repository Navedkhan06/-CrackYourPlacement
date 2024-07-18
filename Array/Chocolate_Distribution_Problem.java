class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        int minDiff=Integer.MAX_VALUE;
        Collections.sort(a);

        for(int i=(m-1);i<a.size();i++)
        {
            minDiff=Math.min((a.get(i)-a.get(i-(m-1))),minDiff);
        }
        return minDiff;
    }
}