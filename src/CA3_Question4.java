import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Name: Jamie Lawlor
 * Class Group: SD2B
 */
public class CA3_Question4 {

    /*
        filename: name of the file to test.
     */
    public static boolean validate(String filename) throws FileNotFoundException {
        File f = new File(filename);
        Scanner key = new Scanner(f);
        String aLine;
        Stack<String> tags = new Stack<>();
        while (key.hasNext()) {
            aLine = key.next();
            //Pushes the starting tags onto the stack
            if (!aLine.contains("</")) {
                tags.push(aLine);

            }
            //Comparing the end tags in the stack to the starting tags and pops the end stack when they match
            if (aLine.contains("</")) {
                /*Creates a substring of the ending tags with its starting point being after the "/"
                and checks does it equal the substring of the starting tags after the "<" in order.
                * */
                if (aLine.substring(2).equals(tags.peek().substring(1))) {
                    tags.pop();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;


     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for (String fName : files) {
            System.out.print(fName + ": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }
}

