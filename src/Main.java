import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        System.out.println("""
                Привет! Это калькулятор, который выполняет операции с римскими и арабскими числами при соблюдении следующих условий:
                 -два операнда и один оператор (+, -, /, *);
                 -оба операнда должны быть либо римской системы, либо арабской;
                 -вводить можно только целые числа от 1 до 10.
                \s
                Введите выражение в консоль.""");
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println(calc(sc.nextLine()));
        }
    }
    public static String calc(String input) {
        String result = "";
        String operator;
        if (input.contains("+")) {
            operator = "+";
        } else if (input.contains("-")) {
            operator = "-";
        } else if (input.contains("*")) {
            operator = "*";
        } else if (input.contains("/")) {
            operator = "/";
        } else {
            throw new RuntimeException("В ведённой строке '" +
                    input + "' нет символа арифметической операции ( +, - , * , / ) ");
        }

        StringBuilder builder = new StringBuilder(input.replaceAll(" ", ""));
        String leftSide = builder.substring(0, builder.indexOf(operator));
        String rightSide = builder.substring(builder.indexOf(operator) + 1, builder.length());

        String numberSystem;
        if (leftSide.chars().allMatch(Character::isLetter) && rightSide.chars().allMatch(Character::isLetter)) {
            numberSystem = "roman";
        } else if (leftSide.chars().allMatch(Character::isDigit) && rightSide.chars().allMatch(Character::isDigit)) {
            numberSystem = "arabian";
        } else {
            throw new RuntimeException("Неверный ввод. Корректный формат:" +
                    " два операнда и один оператор (+, -, /, *); оба операнда должны быть либо римской" +
                    " системы, либо арабской; вводить можно только целые числа от 1 до 10. Вы ввели: " + input);
        }

        switch (numberSystem) {
            case ("arabian") -> result = new ArabianCalc().arabianCalc(Integer.parseInt(leftSide),
                    Integer.parseInt(rightSide), operator);
            case ("roman") -> result = new RomanCalc().romanCalc(leftSide, rightSide, operator);
        }
        return result;
    }

}


