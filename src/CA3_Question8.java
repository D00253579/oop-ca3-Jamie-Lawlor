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
//For loop to iterate through each number and symbol of the equation
            for (int i = 0; i < equation.length(); i++) {
                /*Getting each character and changing it to a string format so we can check if its a
                number or symbol*/
                currentChar = String.valueOf(equation.charAt(i));
                if (currentChar.equals("*") || currentChar.equals("/") || currentChar.equals("+") || currentChar.equals("-") || currentChar.equals("(") ||  currentChar.equals(")")) {
                    operators.push(currentChar);
                }else{
                    //Parse the string to a Double for the numbers queue
                    numbers.push(Double.parseDouble(currentChar));
                }
                /*Ensuring that there are 2 numbers in the numbers queue otherwise there wouldn't be an
                equation to test*/
                if (numbers.size()>1) {
                    if (!operators.isEmpty() && operators.contains("*")) {
                        //Passing into the method to calculate the answer
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
                    /*Once operator is ")", calculate everything that is still left on the stack
                then pop everything*/
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
//End of loop
            finish=true;
        }
        System.out.println("NUMS: "+numbers);
        System.out.println("OPS: " +operators);
    }
public static void topEvaluation(Stack<Double>numbers, Stack<String>operators) {
        //Getting the two numbers and the operator, popping them from the queue and storing them in variables
        double num1 = numbers.pop();
        double num2 = numbers.pop();
        String op = operators.pop();
        double result;
//Switch statement to perform what operator is chosen
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
