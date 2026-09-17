import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // In Java, set.add() returns false if the item is already in the set
            if (!window.add(nums[i])) {
                return true; 
            }
            
            // Keep the window size at most 'k' by removing the oldest element
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        
        return false;
    }
}
