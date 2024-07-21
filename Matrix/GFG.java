public class GFG{
    
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];   // Array to store the left boundary of consecutive 1's
        int[] right = new int[n];  // Array to store the right boundary of consecutive 1's
        int[] height = new int[n]; // Array to store the height of consecutive 1's
        
        Arrays.fill(right, n);
        int maxArea = 0;
        
        for (char[] row : matrix) {
            int curLeft = 0, curRight = n;
            
            // Update height array
            for (int j = 0; j < n; j++) {
                if (row[j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            
            // Update left boundary array
            for (int j = 0; j < n; j++) {
                if (row[j] == '1') {
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            
            // Update right boundary array
            for (int j = n - 1; j >= 0; j--) {
                if (row[j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = n;
                    curRight = j;
                }
            }
            
            // Calculate maximum area for each cell
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
            }
        }
        
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix1 = {
            {'0', '1', '1', '0'},
            {'1', '1', '1', '1'},
            {'1', '1', '1', '1'},
            {'1', '1', '0', '0'}
        };
        
        System.out.println(maximalRectangle(matrix1));
    }
}
