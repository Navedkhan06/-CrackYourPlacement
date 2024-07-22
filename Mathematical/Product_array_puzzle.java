class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
        // code here
        long total=1;
        long zeroCount=0;
        int zeroPosition=-1;
        long res[]= new long[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!= 0)
            {
                total*=(long)nums[i];
            }
            else{
                zeroCount++;
                zeroPosition=i;
            }
        }
        if(zeroCount>1)
        {
            for(int i=0;i<res.length;i++)
            {
                res[i]=0;
            }
            return res;
        }
        for(int i=0;i<res.length;i++)
        {
            if(zeroCount==1)
            {
                if(zeroPosition==i)
                {
                    res[i]=total;
                }
                else
                {
                    res[i]=0;
                }
            }
            else
            {
                res[i]=total/(long)nums[i];
            
            }
        }
        return res;
	} 
} 