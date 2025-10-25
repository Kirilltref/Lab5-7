package main.java.academy.java.base;

public class StringOperations {

    public static int getSummaryLength(String[] strings) {
        int sum = 0;
        for (String s : strings) {
            sum += s.length();
        }
        return sum;
    }


    public static String getFirstAndLastLetterString(String string) {
        int len = string.length();
        if (len == 0) {
            return ""; // Empty string for no characters
        } else {
            char first = string.charAt(0);
            char last = string.charAt(len - 1);
            return String.valueOf(first) + String.valueOf(last);
        }
    }


    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        if (index < 0 || index >= string1.length() || index >= string2.length()) {
            return false;
        }
        return string1.charAt(index) == string2.charAt(index);
    }


    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        int pos1 = string1.indexOf(character);
        int pos2 = string2.indexOf(character);
        return pos1 == pos2 && pos1 != -1;
    }


    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        int pos1 = string1.lastIndexOf(character);
        int pos2 = string2.lastIndexOf(character);
        return pos1 == pos2 && pos1 != -1;
    }


    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        int pos1 = string1.indexOf(str);
        int pos2 = string2.indexOf(str);
        return pos1 == pos2 && pos1 != -1;
    }

    // 7. Проверяет, совпадает ли позиция последнего вхождения подстроки
    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        int pos1 = string1.lastIndexOf(str);
        int pos2 = string2.lastIndexOf(str);
        return pos1 == pos2 && pos1 != -1;
    }

    public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }


    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }


    public static boolean isLess(String string1, String string2) {
        return string1.compareTo(string2) < 0;
    }


    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1.compareToIgnoreCase(string2) < 0;
    }


    public static String concat(String string1, String string2) {
        return string1 + string2;
    }


    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }


    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }


    public static String getCommonPrefix(String string1, String string2) {
        int minLength = Math.min(string1.length(), string2.length());
        for (int i = 0; i < minLength; i++) {
            if (string1.charAt(i) != string2.charAt(i)) {
                return string1.substring(0, i);
            }
        }
        return string1.substring(0, minLength);
    }


    public static String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }


    public static boolean isPalindrome(String string) {
        String reversed = reverse(string);
        return string.equals(reversed);
    }


    public static boolean isPalindromeIgnoreCase(String string) {
        String lower = string.toLowerCase();
        String reversed = reverse(lower);
        return lower.equals(reversed);
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        String longest = "";
        for (String s : strings) {
            if (isPalindromeIgnoreCase(s) && s.length() > longest.length()) {
                longest = s;
            }
        }
        return longest;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        if (index + length > string1.length() || index + length > string2.length()) {
            return false;
        }
        String sub1 = string1.substring(index, index + length);
        String sub2 = string2.substring(index, index + length);
        return sub1.equals(sub2);
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1,
                                                        String string2, char replaceInStr2, char replaceByInStr2) {
        String modified1 = string1.replace(replaceInStr1, replaceByInStr1);
        String modified2 = string2.replace(replaceInStr2, replaceByInStr2);
        return modified1.equals(modified2);
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1,
                                                     String string2, String replaceInStr2, String replaceByInStr2) {
        String modified1 = string1.replace(replaceInStr1, replaceByInStr1);
        String modified2 = string2.replace(replaceInStr2, replaceByInStr2);
        return modified1.equals(modified2);
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        String noSpaces = string.replace(" ", "").toLowerCase();
        return isPalindrome(noSpaces);
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return string1.trim().equals(string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(String.format("%.2f", array[i]));
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        return sb;
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(String.format("%.2f", array[i]));
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        return sb;
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder sb = new StringBuilder(string);
        for (int i = positions.length - 1; i >= 0; i--) {
            sb.deleteCharAt(positions[i]);
        }
        return sb;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        StringBuilder sb = new StringBuilder(string);
        int offset = 0;
        for (int i = 0; i < positions.length; i++) {
            sb.insert(positions[i] + offset, characters[i]);
            offset++;
        }
        return sb;
    }
}