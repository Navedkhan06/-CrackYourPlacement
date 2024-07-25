class Solution {
    public int cntNoOfSplits(int []nums,int maxSum){
        int noOfSplits=1,sum=0;
        for(int x:nums){
            if(sum+x<=maxSum) sum+=x;
            else{
                noOfSplits++;
                sum=x;
            }
        }
        return noOfSplits;
    }
    public int splitArray(int[] nums, int k) {
        int start=Integer.MIN_VALUE,end=0,mid=0;
        for(int x:nums){
            start=Math.max(start,x);
            end+=x;
        }
        while(start<=end){
            mid = (start+end)/2;
            int noOfSplits = cntNoOfSplits(nums,mid);
            if(noOfSplits<=k) end=mid-1;
            else start=mid+1;
        }
        return start;
    }
}