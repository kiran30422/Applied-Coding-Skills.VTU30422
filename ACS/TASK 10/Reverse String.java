class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        
        while (left < right) {
            // Swap the characters
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            // Move the pointers toward the center
            left++;
            right--;
        }
    }
}
