class RomanCalc {

    final String[] romanNumbers = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    final int[] arabicNumbers = {100, 90, 50, 40, 10, 9, 5, 4, 1};

    public int fromRoman(String romanNumber) {
        String remainingValue = romanNumber;
        int result = 0;

        for (int i = 0; i < romanNumbers.length; i++) {
            while (remainingValue.startsWith(romanNumbers[i])) {
                remainingValue = remainingValue.substring(romanNumbers[i].length());
                result += arabicNumbers[i];
            }
        }
        return result;
    }

    public String toRoman(int arabicNumber) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arabicNumbers.length; i++) {
            while ((arabicNumber >= arabicNumbers[i])) {
                arabicNumber -= arabicNumbers[i];
                result.append(romanNumbers[i]);
            }
        }
        return result.toString();
    }

    public String romanCalc(String leftSide, String rightSide, String operator) {
        int leftArabic = fromRoman(leftSide);
        int rightArabic = fromRoman(rightSide);

        if (leftArabic == 0 || rightArabic == 0) {
            throw new RuntimeException("Один из символов не является римской цифрой в диапазоне I - X, вы ввели " +
                    leftSide + " и " + rightSide);
        }
        int calc = Integer.parseInt(new ArabianCalc()
                .arabianCalc(String.valueOf(leftArabic), String.valueOf(rightArabic), operator));

        if (calc < 1) {
            throw new RuntimeException("В римской системе нет отрицательных чисел. Результат в арабской системе: " + calc);
        }

        return toRoman(calc);
    }
}





