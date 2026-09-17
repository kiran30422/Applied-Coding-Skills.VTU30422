import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] nums = {2, 3, 5};

        int n = nums.length;
        int[] result = new int[n];

        // Prefix sum of elements
        long[] prefix = new long[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {

            // Sum of differences with elements on the left
            long leftSum = (long) nums[i] * i - (i > 0 ? prefix[i - 1] : 0);

            // Sum of differences with elements on the right
            long rightSum = (prefix[n - 1] - prefix[i])
                    - (long) nums[i] * (n - i - 1);

            result[i] = (int) (leftSum + rightSum);
        }

        System.out.println(Arrays.toString(result));
    }
}
