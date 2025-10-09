class Remove1 {
    public int removeElement(int[] nums, int val) {
        int k = 0; // pointer for placing non-val elements
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k; // number of elements not equal to val
    }

    // You can test it with a main method
    public static void main(String[] args) {
        Remove1 sol = new Remove1();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int k = sol.removeElement(nums, val);
        
        System.out.println("k = " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
