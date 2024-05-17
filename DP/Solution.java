import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        // Provided input example
        int n = 4;
        int[] height = {4, 1, 4, 10};
        int[] width = {6, 2, 5, 12};
        int[] length = {7, 3, 6, 32};

        int maxHeight = maxHeight(height, width, length, n);
        System.out.println("Output: " + maxHeight); // Expected output: 60
    }

    public static int maxHeight(int[] height, int[] width, int[] length, int n) {
        // Create an array to hold all rotations of the boxes
        Dimension[] allRotationInput = new Dimension[n * 3];

        // Create all rotations
        createAllRotation(height, length, width, allRotationInput);

        // Sort the boxes based on area in descending order
        Arrays.sort(allRotationInput, (d1, d2) -> (d2.length * d2.width) - (d1.length * d1.width));

        // Array to store the maximum height at each index
        int[] T = new int[allRotationInput.length];

        // Initialize the maximum height array with the heights of the boxes
        for (int i = 0; i < T.length; i++) {
            T[i] = allRotationInput[i].height;
        }

        // Compute the maximum height stack possible
        for (int i = 1; i < T.length; i++) {
            for (int j = 0; j < i; j++) {
                if (allRotationInput[i].length < allRotationInput[j].length &&
                    allRotationInput[i].width < allRotationInput[j].width) {
                    T[i] = Math.max(T[i], T[j] + allRotationInput[i].height);
                }
            }
        }

        // Find the maximum value in T, which is the answer
        int maxHeight = 0;
        for (int heightVal : T) {
            if (heightVal > maxHeight) {
                maxHeight = heightVal;
            }
        }

        return maxHeight;
    }

    public static void createAllRotation(int[] height, int[] length, int[] width, Dimension[] allRotationInput) {
        int idx = 0;
        for (int i = 0; i < height.length; i++) {
            // Original orientation
            allRotationInput[idx++] = new Dimension(height[i], Math.max(length[i], width[i]), Math.min(length[i], width[i]));
            // First rotation
            allRotationInput[idx++] = new Dimension(length[i], Math.max(height[i], width[i]), Math.min(height[i], width[i]));
            // Second rotation
            allRotationInput[idx++] = new Dimension(width[i], Math.max(height[i], length[i]), Math.min(height[i], length[i]));
        }
    }

    static class Dimension {
        int height;
        int length;
        int width;

        Dimension(int height, int width, int length) {
            this.height = height;
            this.width = width;
            this.length = length;
        }
    }
}
