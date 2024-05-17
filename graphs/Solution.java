class Solution {
    public void shortest_distance(int[][] matrix) {
        int n = matrix.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] != -1 && matrix[k][j] != -1 &&
                        (matrix[i][j] == -1 || matrix[i][j] > matrix[i][k] + matrix[k][j])) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }

            // Print the matrix after each iteration
            System.out.println("Iteration " + (k + 1) + ":");
            printMatrix(matrix);
            System.out.println();
        }
    }

    // Helper function to print the matrix
    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) {
                    System.out.print("inf\t");
                } else {
                    System.out.print(matrix[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }


 
    public static void main(String[] args) {
        box_stack solution = new box_stack();

        int[][] matrix = {
            {0, 3, -1, 5},
            {2, 0, -1, 4},
            {0, 1, 0, -1},
            {-1, -1, 2, 0}
        };

        System.out.println("Original Matrix:");
        solution.printMatrix(matrix);
        System.out.println();

        // Run the shortest_distance method
        solution.shortest_distance(matrix);
    }

}