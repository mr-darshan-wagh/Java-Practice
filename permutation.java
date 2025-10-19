class permutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    // ✅ Add this part to run and test your code
    public static void main(String[] args) {
        permutation sol = new permutation();
        int[] nums = {1, 2, 3};
        sol.nextPermutation(nums);

        System.out.print("Next permutation: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
