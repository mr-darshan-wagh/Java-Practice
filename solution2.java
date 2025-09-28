import java.util.*;

class solution2 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currValue = map.get(s.charAt(i));

            if (currValue < prevValue) {
                total -= currValue;  // subtract if smaller before larger
            } else {
                total += currValue;  // otherwise add
            }

            prevValue = currValue;
        }

        return total;
    }

    public static void main(String[] args) {
        solution2 sol = new solution2();
        System.out.println(sol.romanToInt("III"));      // Output: 3
        System.out.println(sol.romanToInt("LVIII"));    // Output: 58
        System.out.println(sol.romanToInt("MCMXCIV"));  // Output: 1994
    }
}
