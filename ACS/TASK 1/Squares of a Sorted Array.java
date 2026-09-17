import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] nums = {-4, -1, 0, 3, 10};

        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;

        // Fill result from right to left
        for (int i = n - 1; i >= 0; i--) {

            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[i] = leftSquare;
                left++;
            } else {
                result[i] = rightSquare;
                right--;
            }
        }

        System.out.println(Arrays.toString(result));
    }
}
