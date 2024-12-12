public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * If the given number is not in a valid format, returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return the decimal value or -1 if invalid
     */
    public static int number2Int(String num) {
        if (!isNumber(num)) { // check if the input is a valid number
            return -1;
        }
        int indexB = num.indexOf('b');//Find the index of 'b' witch separates the number and base
        String numberPart = indexB >= 0 ? num.substring(0, indexB) : num;//Exctract the number part
        int base = indexB >= 0 ? baseFromString(num.substring(indexB + 1)) : 10;// determine the base or default to 10

        int value = 0;//initialize the result value
        for (char c : numberPart.toCharArray()) {
            int digit = charToVal(c);// convert the character to its integer value
            if (digit < 0 || digit >= base) {// validate the digit against the base
                return -1; // return -1 if the digit is invalid
            }
            value = value * base + digit;  // update the result value
        }
        return value; //return the converted decimal value
    }

    /**
     * Checks if the given String is in a valid "number" format.
     * @param a a String representing a number
     * @return true if valid, false otherwise
     */
    public static boolean isNumber(String a) {
        if (a == null || a.isEmpty() || a.contains(" ")) { // check for null, empty or spaces
            return false;
        }

        int indexB = a.indexOf('b'); // find the index of 'b' which separates the number and base
        String numberPart = indexB >= 0 ? a.substring(0, indexB) : a; // extract the number part
        String basePart = indexB >= 0 ? a.substring(indexB + 1) : "10"; // extract the base part or default to 10

        int base = baseFromString(basePart);// convert the base to an integer
        if (base < 2 || base > 16 || numberPart.isEmpty()) { // validate the base and check the number part is not empty
            return false;
        }

        for (char c : numberPart.toCharArray()) {// read over each character of the number part
            int val = charToVal(c); // convert the character to its integer value
            if (val < 0 || val >= base) { // validate the digit against the base
                return false;
            }
        }

        return true;
    }

    /**
     * Convert an integer to its representation in a specified base.
     * @param num the natural number (>= 0)
     * @param base the base (2 to 16)
     * @return the String representation or "" if invalid
     */
    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) {// validate the number and base
            return "";
        }
        if (num == 0) { // case for 0
            return "0b" + base;
        }

        StringBuilder result = new StringBuilder(); // initialize a StringBuilder for the result
        String digits = "0123456789ABCDEF"; //Define valid digits for bases up to 16

        while (num > 0) {// repeat until the number is converted
            result.insert(0, digits.charAt(num % base));//add the corresponding number to the result
            num /= base;// divide the number by the base
        }

        result.append("b").append(base);//add the base to the result
        return result.toString();// final result
    }



    /**
     * Checks if two numbers are equal in value.
     * @param n1 the first number as a String
     * @param n2 the second number as a String
     * @return true if equal, false otherwise
     */
    public static boolean equals(String n1, String n2) {
        if (n1 == null || n2 == null || !isNumber(n1) || !isNumber(n2)) {
            return false;git branch

        }
        return number2Int(n1) == number2Int(n2); // compare their numeric values
    }


    /**
     * Finds the index of the largest number in an array.
     * @param arr an array of numbers as Strings
     * @return the index of the largest number, or -1 if none are valid
     */
    public static int maxIndex(String[] arr) {
        int maxVal = -1;
        int maxIdx = -1;
        for (int i = 0; i < arr.length; i++) {
            int value = number2Int(arr[i]);// convert the current number to its integer value
            if (value > maxVal) {
                maxVal = value;// update the maximum value
                maxIdx = i; // update the index of the maximum value
            }
        }
        return maxIdx;
    }


    private static int charToVal(char c) {// Convert a character to its integer value
        if (c >= '0' && c <= '9') {
            return c - '0'; // convert '0' - '9' to 0-9
        } else if (c >= 'A' && c <= 'F') {
            return 10 + (c - 'A');// convert 'A' - 'F' to 10-15
        }
        return -1;
    }



    private static int baseFromString(String baseStr) {// convert a string to a base
        if (baseStr == null || baseStr.isEmpty()) {
            return -1;
        }
        if (baseStr.length() == 1) {
            char c = baseStr.charAt(0);
            if (c >= '2' && c <= '9') { //convert '2'-'9' to 2-9
                return c - '0';
            } else if (c >= 'A' && c <= 'G') {//convert 'A'-'G' to 10-16
                return 10 + (c - 'A');
            }
        } else {
            try {
                int b = Integer.parseInt(baseStr);//parse character base strings
                if (b >= 2 && b <= 16) {
                    return b;
                }
            } catch (NumberFormatException ignored) {
            }
        }
        return -1;
    }
}

