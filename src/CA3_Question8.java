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
        Stack<Integer>numbers=new Stack<>();
        Stack<String>operators=new Stack<>();
        boolean finish=false;
        int result;
        while(!finish){
//            for (int i=0; i<equation.length(); i++){
//            if (equation.contains("+")) {
//                if (equation.charAt(i) == '+'){
//                    operators.push(equation.substring(i));
//                }
//                numbers.push(Integer.parseInt(equation.substring(i)));
//            }
//            }

            for (int i = 0; i < equation.length(); i++) {
                String currentChar = String.valueOf(equation.charAt(i));
                if (!currentChar.equals("(")){
                    numbers.push(Integer.parseInt(currentChar));
                }else if (currentChar.equals("(")){
                    operators.push(currentChar);
                }else if (currentChar.equals("+") || currentChar.equals( "-") || currentChar.equals(" *") || currentChar.equals("/")){
                    operators.push(currentChar);
                }
                System.out.println(operators);
//                if (!currentChar.equals("+")){
//                    numbers.push(Integer.parseInt(currentChar));
//                }else{
//                    operators.push(currentChar);
//                }
//            if (!numbers.isEmpty()&&!operators.isEmpty()){
//
//                operators.pop();
//
//
//            }
            }
            finish=true;
        }
        System.out.println(numbers);
        System.out.println(operators);
    }
}
