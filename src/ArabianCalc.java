class ArabianCalc {
    public String arabianCalc(String leftSide, String rightSide, String operator) {
        String result = "";
        if (Integer.parseInt(leftSide) > 10 || Integer.parseInt(rightSide) > 10
                || Integer.parseInt(leftSide) < 1 || Integer.parseInt(rightSide) < 1) {
            throw new RuntimeException("Калькулятор работает только с числами от 1 до 10. Вы ввели: " +
                    leftSide + " и " + rightSide);
        }

        switch (operator) {
            case ("+") -> result = String.valueOf(Integer.parseInt(leftSide) + Integer.parseInt(rightSide));
            case ("-") -> result = String.valueOf(Integer.parseInt(leftSide) - Integer.parseInt(rightSide));
            case ("*") -> result = String.valueOf(Integer.parseInt(leftSide) * Integer.parseInt(rightSide));
            case ("/") -> result = String.valueOf(Integer.parseInt(leftSide) / Integer.parseInt(rightSide));
        }
        return result;
    }
}
