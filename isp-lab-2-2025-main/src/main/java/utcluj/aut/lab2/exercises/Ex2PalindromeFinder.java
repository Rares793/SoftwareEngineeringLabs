package utcluj.aut.lab2.exercises;

/**
 * Class for finding palindromic numbers in a given range.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex2PalindromeFinder {

    /**
     * Checks if a number is palindromic (reads the same backward as forward).
     *
     * @param number the number to check
     * @return true if the number is palindromic, false otherwise
     */
    public boolean isPalindromic(int number) {
        // TODO: Implement this method
        // 1. Convert the number to a string
        // 2. Check if the string reads the same forward and backward
        // 3. Return the result
        String numberS = Integer.toString(number);
        int length = numberS.length();
        for(int i = 0; i < length / 2; i++)
            if(numberS.charAt(i) != numberS.charAt(length - i - 1))
                return false;
        return true;
    }

    /**
     * Finds all palindromic numbers in the given range [a, b], inclusive.
     *
     * @param a the lower bound of the range
     * @param b the upper bound of the range
     * @return an array of all palindromic numbers in the range
     * @throws IllegalArgumentException if a > b
     */
    public int[] findPalindromes(int a, int b) {
        // TODO: Implement this method
        // 1. Validate that a <= b, throw IllegalArgumentException if not
        // 2. Create an array to store palindromic numbers
        // 3. Iterate through each number in the range [a, b]
        // 4. Check if each number is palindromic, add to array if true
        // 5. Return the array
        if(a > b)
            throw new IllegalArgumentException("a > b, sorry");
        int size = 0;
        for(int i = a; i <= b; i++)
            if(isPalindromic(i))
                size++;
        int[] array = new int[size];
        int j = 0;

        while(a <= b){
            if(isPalindromic(a))
                array[j++] = a;
            a++;
        }
        return array;
    }

    public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create an instance of PalindromeFinder
        // 2. Define a range of numbers to check for palindromes
        // 3. Find palindromes in the defined range
        // 4. Print the array of palindromes
        Ex2PalindromeFinder PalindromeFinder = new Ex2PalindromeFinder();

        int a = 10, b = 9999;
        int[] array = PalindromeFinder.findPalindromes(a, b);
        for (int j : array) System.out.printf("%d ", j);

    }
}
