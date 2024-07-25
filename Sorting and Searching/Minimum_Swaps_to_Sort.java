class Solution {
    // Function to find the minimum number of pages.
    public static long findPages(int N, int[] arr, int m) 
    {
        if(N < m)
        {
            return -1;
        }
        
        int low = arr[0];
        int high = 0;
        
        for (int i = 0; i < N; i++)
        {
            if(arr[i] > low)
            {
                low = arr[i];
            }
            high += arr[i];
        }
        
        while(low <= high)
        {
            int mid = (low + high) / 2;
            int students = countstudents(arr, mid);
            if(students > m)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        
        return low;
    }
    
    public static int countstudents(int[] arr, int pages)
    {
        int students = 1;
        long pagestudent = 0;
        
        for(int i = 0; i < arr.length; i++)
        {
            if(pagestudent + arr[i] <= pages)
            {
                pagestudent += arr[i];
            }
            else
            {
                students += 1;
                pagestudent = arr[i];
            }
        }
        
        return students;
    }
}