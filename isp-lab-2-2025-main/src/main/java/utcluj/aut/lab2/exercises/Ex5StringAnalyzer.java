package utcluj.aut.lab2.exercises;

/**
 * Class for analyzing strings.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex5StringAnalyzer {

    /**
     * Parses the input string into an array of strings, splitting by semicolons.
     *
     * @param input the input string to parse
     * @return an array of strings
     */
    public String[] parseInput(String input) {
        if(input == null) {
            throw new IllegalArgumentException("Input is empty!");
        }
        String[] parts = input.split(";");
        for(int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        return parts;
    }

    /**
     * Finds the longest string(s) in the array.
     * If multiple strings have the same length, all are returned.
     *
     * @param strings the array of strings to analyze
     * @return an array of the longest strings
     */
    public String[] findLongest(String[] strings) {
        int maximumLength = 0, index = 0;
        for (String string : strings) {
            if (string.length() > maximumLength) {
                maximumLength = string.length();
                index = 1;
            } else if(string.length() == maximumLength) {
                index++;
            }
        }
        String[] longestStrings = new String[index];
        index = 0;
        for(String string : strings) {
            if(maximumLength == string.length()) {
                longestStrings[index] = string;
                index++;
            }
        }
        return longestStrings;
    }

    /**
     * Finds the shortest string(s) in the array.
     * If multiple strings have the same length, all are returned.
     *
     * @param strings the array of strings to analyze
     * @return an array of the shortest strings
     */
    public String[] findShortest(String[] strings) {
        int minimumLength = 0, index = 0;
        for (String string : strings) {
            if (string.length() < minimumLength || minimumLength == 0) {
                minimumLength = string.length();
                index = 1;
            } else if(string.length() == minimumLength) {
                index++;
            }
        }
        String[] shortestStrings = new String[index];
        index = 0;
        for(String string : strings) {
            if(minimumLength == string.length()) {
                shortestStrings[index] = string;
                index++;
            }
        }
        return shortestStrings;
    }

    /**
     * Counts the number of vowels in each string.
     *
     * @param strings the array of strings to analyze
     * @return a map from string to vowel count
     */
    public int[] countVowels(String[] strings) {
        int[] vowelsCountArray = new int[strings.length];
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int index = 0;
        for(String string : strings) {
            int vowelsCounter = 0;
            for(char character : string.toLowerCase().toCharArray()) {
                for(char vowel : vowels) {
                    if(character == vowel) {
                        vowelsCounter++;
                        break;
                    }
                }
            }
            vowelsCountArray[index] = vowelsCounter;
            index++;
        }
        return vowelsCountArray;
    }

    /**
     * Counts the number of consonants in each string.
     *
     * @param strings the array of strings to analyze
     * @return an array of integers representing the consonant count for each string
     */
    public int[] countConsonants(String[] strings) {
        int[] consonantCountArray = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            int consonantsCounter = 0;
            for (char character : strings[i].toLowerCase().toCharArray()) {
                if (Character.isLetter(character) && "aeiouAEIOU".indexOf(character) == -1) {
                    consonantsCounter++;
                }
            }
            consonantCountArray[i] = consonantsCounter;
        }
        return consonantCountArray;
    }

    /**
     * Finds the string(s) with the most vowels.
     * If multiple strings have the same number of vowels, all are returned.
     *
     * @param strings the array of strings to analyze
     * @return an array of strings with the most vowels
     */
    public String[] findMostVowels(String[] strings) {
        int[] vowelsCountArray = countVowels(strings);
        int mostVowels = 0, index = 0;
        for(int i : vowelsCountArray) {
            if(i > mostVowels) {
                mostVowels = i;
                index = 1;
            } else if(i == mostVowels) {
                index++;
            }
        }
        String[] mostVowelsStrings = new String[index];
        index = 0;
        for(int i = 0; i < strings.length; i++) {
            if(mostVowels == vowelsCountArray[i]) {
                mostVowelsStrings[index] = strings[i];
                index++;
            }
        }
        return mostVowelsStrings;
    }

    /**
     * Finds the string(s) with the most consonants.
     * If multiple strings have the same number of consonants, all are returned.
     *
     * @param strings the array of strings to analyze
     * @return an array of strings with the most consonants
     */
    public String[] findMostConsonants(String[] strings) {
        int[] consonantsCountArray = countConsonants(strings);
        int mostConsonants = 0, index = 0;
        for(int i : consonantsCountArray) {
            if(i > mostConsonants) {
                mostConsonants = i;
                index = 1;
            } else if(i == mostConsonants) {
                index++;
            }
        }
        String[] mostConsonantsStrings = new String[index];
        index = 0;
        for(int i = 0; i < strings.length; i++) {
            if(mostConsonants == consonantsCountArray[i]) {
                mostConsonantsStrings[index] = strings[i];
                index++;
            }
        }
        return mostConsonantsStrings;
    }

    public static void main(String[] args) {
        Ex5StringAnalyzer analyzer = new Ex5StringAnalyzer();
        String string = "Ana; are; cele; mai; multe; mere";
        String[] parsedInput = analyzer.parseInput(string);
        String[] longestStrings = analyzer.findLongest(parsedInput);
        String[] shortestStrings = analyzer.findShortest(parsedInput);
        System.out.print("The longest strings are: ");
        for(String s : longestStrings) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.print("The shortest strings are: ");
        for(String s : shortestStrings) {
            System.out.print(s + " ");
        }
        System.out.println();
        int[] vowelsArray = analyzer.countVowels(parsedInput);
        int[] consonantsArray = analyzer.countConsonants(parsedInput);
        System.out.print("For each string above, the number of vowels is: ");
        for(int i : vowelsArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("For each string above, the number of consonants is: ");
        for(int i : consonantsArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        String[] mostVowelsStrings = analyzer.findMostVowels(parsedInput);
        String[] mostConsonantsStrings = analyzer.findMostConsonants(parsedInput);
        System.out.print("The strings with the most vowels are: ");
        for(String s : mostVowelsStrings) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.print("The strings with the most consonants are: ");
        for(String s : mostConsonantsStrings) {
            System.out.print(s + " ");
        }
    }
}