import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Jamie Lawlor
 *  Class Group: SD2B
 */
public class  CA3_Question8 {

    /*
        Reads in an equation from the user
     */
    public static void main(String[] args) {
        String equation;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter equation");
        equation = in.nextLine().trim();
        Stack<Double>numbers=new Stack<>();
        Stack<String>operators=new Stack<>();
        boolean finish=false;
        while(!finish) {
            String currentChar;

            for (int i = 0; i < equation.length(); i++) {
                currentChar = String.valueOf(equation.charAt(i));
                if (currentChar.equals("*") || currentChar.equals("/") || currentChar.equals("+") || currentChar.equals("-") || currentChar.equals("(") ||  currentChar.equals(")")) {
                    operators.push(currentChar);
                }else{
                    numbers.push(Double.parseDouble(currentChar));
                }
                if (numbers.size()>1) {
                    if (!operators.isEmpty() && operators.contains("*")) {
                        topEvaluation(numbers, operators);
                    }
                    if (operators.contains("/")) {
                        topEvaluation(numbers, operators);
                    }
                    if (operators.contains("+")) {
                        topEvaluation(numbers, operators);
                    }
                    if (operators.contains("-")) {
                        topEvaluation(numbers, operators);
                    }
                }
                    if (!operators.isEmpty() && operators.peek().equals(")")){
                    if (!operators.peek().equals("(") && numbers.size()>1){
                        topEvaluation(numbers,operators);
                        operators.pop();
                    }
                   else{
                       operators.pop();
                    }

                }



                }

            finish=true;
        }

        System.out.println("NUMS: "+numbers);
        System.out.println("OPS: " +operators);
    }
public static void topEvaluation(Stack<Double>numbers, Stack<String>operators) {
        double num1 = numbers.pop();
        double num2 = numbers.pop();
        String op = operators.pop();
        double result;

            switch (op) {
                case"(": {
                    operators.pop();
                    break;
                }
                case "+": {
                    result = num2 + num1;
                    numbers.push(result);
                    break;
                }

                case "-": {
                    result = num2 - num1;
                    numbers.push(result);
                    break;
                }
                case "*": {
                    result = num2 * num1;
                    numbers.push(result);
                    break;
                }
                case "/": {
                    result = num2 / num1;
                    numbers.push(result);
                    break;
                }
            }



}
}
