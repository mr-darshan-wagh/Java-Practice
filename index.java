class index {
    public int strStr(String haystack, String needle) {
        // Use Java's built-in indexOf() method
        return haystack.indexOf(needle);
    }

    // You can test the code using main method
    public static void main(String[] args) {
        index sol = new index();

        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println(sol.strStr(haystack1, needle1)); // Output: 0

        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println(sol.strStr(haystack2, needle2)); // Output: -1
    }
}
