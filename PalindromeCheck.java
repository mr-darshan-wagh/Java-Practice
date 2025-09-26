public class PalindromeCheck {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x % 10 == 0 && x != 0) return false;

        int reversedHalf = 0;
        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x /= 10;
        }

        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static void main(String[] args) {
        PalindromeCheck pc = new PalindromeCheck();

        int test1 = 121;
        int test2 = -121;
        int test3 = 10;

        System.out.println(test1 + " -> " + pc.isPalindrome(test1)); // true
        System.out.println(test2 + " -> " + pc.isPalindrome(test2)); // false
        System.out.println(test3 + " -> " + pc.isPalindrome(test3)); // false
    }
}
