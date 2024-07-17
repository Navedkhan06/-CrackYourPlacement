class Solution {
    public int reversePairs(int[] nums) {
        /*int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>2*nums[j]) count++;
            }
        }
        return count;
        */
        return mergeSort(nums,0,nums.length-1);
    }
    public int mergeSort(int nums[],int low,int high){
        int count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            count += mergeSort(nums, low, mid);
            count += mergeSort(nums, mid + 1, high);
            count += merge(nums, low, mid, high);
        }
        return count;
    }
    public int merge(int []nums, int low,int mid,int high){
        int[] leftArray = Arrays.copyOfRange(nums, low, mid + 1);
        int[] rightArray = Arrays.copyOfRange(nums, mid + 1, high + 1);
        
        int i = 0, j = 0, k = low;
        int count = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if ((long) leftArray[i] > 2 * (long) rightArray[j]) {
                count += leftArray.length - i;
                j++;
            } else {
                i++;
            }
        }

        i = 0;
        j = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k++] = leftArray[i++];
            } else {
                nums[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            nums[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            nums[k++] = rightArray[j++];
        }

        return count;
    }

}