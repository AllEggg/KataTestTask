class ArabianCalc {
    public String arabianCalc(int leftSide, int rightSide, String operator) {
        String result = "";
        if (leftSide > 10 || rightSide > 10
                || leftSide < 1 || rightSide < 1) {
            throw new RuntimeException("Калькулятор работает только с числами от 1 до 10. Вы ввели: " +
                    leftSide + " и " + rightSide);
        }

        switch (operator) {
            case ("+") -> result = String.valueOf(leftSide + rightSide);
            case ("-") -> result = String.valueOf(leftSide - rightSide);
            case ("*") -> result = String.valueOf(leftSide * rightSide);
            case ("/") -> result = String.valueOf(leftSide / rightSide);
        }
        return result;
    }
}
