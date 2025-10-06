class remove {
    public int removeDuplicates(int[] nums) {
        // If the array has only one element, it's already unique
        if (nums.length == 0) return 0;
        
        // Pointer for the position of the next unique element
        int k = 1;

        // Start from the second element
        for (int i = 1; i < nums.length; i++) {
            // If current element is not equal to the previous unique one
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i]; // Place it in the next unique position
                k++; // Increase count of unique elements
            }
        }
        
        // k is the number of unique elements
        return k;
    }

    // You can test the code with this main method
    public static void main(String[] args) {
        remove sol = new remove();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = sol.removeDuplicates(nums);
        
        System.out.println("Unique count: " + k);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
