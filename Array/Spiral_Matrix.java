class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = -1;

        int dir = 1;

        List<Integer> result = new ArrayList<>();

        while(rows > 0 && cols > 0){
            for (int i = 0; i < cols; i++) {
                col += dir;
                result.add(matrix[row][col]);
            }
            rows--;

            for (int i = 0; i < rows; i++) {
                row += dir;
                result.add(matrix[row][col]);
            }
            cols--;

            dir *= -1;
        }

        return result;
    }
}