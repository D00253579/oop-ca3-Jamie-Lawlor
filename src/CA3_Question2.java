import java.util.Scanner;
import java.util.Stack;

/**
 * Name: Jamie Lawlor
 * Class Group: SD2B
 */


public class CA3_Question2 {
    //Creating a simple class to store row and column.
    public static class Pair {
        int row;
        int column;

        public Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

    }   /*
        Starter function to create the 2D array and populate it with 0.
     */

    public static int[][] floodFillStart() {
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                arr[x][y] = 0;
            }
        }
        return arr;
    }

    /*
        Helper function to display the image.
     */
    public static void display(int[][] arr) {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }

    private static void fill(int r, int c, int[][] arr) {
        /*Creating the stack with my class and creating a new object using the inputs from the start
        method, then pushing onto the stack.
         */
        Stack<Pair> coordinates = new Stack<>();
        Pair p1 = new Pair(r, c);
        coordinates.push(p1);
        int order = 1;
        //Do while loop to perform the operations until the stack is empty.
        do {
            //Creating another object to store the current values at the top of the stack.
            Pair peekCoordinates = coordinates.peek();
            //Separating them into row and column using getters from class.
            int x = peekCoordinates.getRow();
            int y = peekCoordinates.getColumn();
            //Removing the pair at the top of the stack
            coordinates.pop();
            //Placing '1' in the location of the row and column at the top of the stack.
            if (arr[x][y] == 0) {
                //Ensuring the value is incrementing.
                arr[x][y] = order++;
                /* Had to add an extra line to all statements that were checking the directions
                as when I ran it with test cases such as row 2 column 5 being the beginning coordinate,
                I received an ArrayIndexOutOfBoundsException.
                */

                /* Checking surrounding coordinates in North, East, South and West directions
                and if those locations haven't been filled then push them to the stack and process repeats.
                */
                if (y + 1 < 10 && arr[x][y + 1] == 0) {
                    coordinates.push(new Pair(x, y + 1));
                } else if (x + 1 < 10 && arr[x + 1][y] == 0) {
                    coordinates.push(new Pair(x + 1, y));
                } else if (y - 1 >= 0 && arr[x][y - 1] == 0) {
                    coordinates.push(new Pair(x, y - 1));
                } else if (x - 1 >= 0 && arr[x - 1][y] == 0) {
                    coordinates.push(new Pair(x - 1, y));
                }
            }

        } while (!coordinates.isEmpty());
    }

    public static void start() {
        int[][] arr = floodFillStart();
        //Getting user input.
        Scanner key = new Scanner(System.in);
        System.out.println("Please enter which row (0-9)");
        int r = key.nextInt();
        System.out.println("Please enter which column(0-9)");
        int c = key.nextInt();
        //Takes in user inputs and the 10x10 array of integers set to 0 in the floodFillStart method.
        fill(r, c, arr);
        //Displaying the 2D Array.
        display(arr);
    }

    public static void main(String[] args) {
        start();
    }
}
