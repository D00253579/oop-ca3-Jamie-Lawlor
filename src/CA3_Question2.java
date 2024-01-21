import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Jamie Lawlor
 *  Class Group: SD2B
 */


public class CA3_Question2
{
    public class Pair{
        int row;
        int column;
public Pair(int row, int column){
    this.row=row;
    this.column=column;
}
    }   /*
        Starter function to create the 2D array and populate it with 0

     */
    public static int[][]  floodFillStart() {
        Scanner kb = new Scanner(System.in);
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
       return arr;
    }
    /*
        Helper function to display the image
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void fill(int r, int c, int[][] arr)
    {
        Scanner key=new Scanner(System.in);
    Stack<Integer>coordinates=new Stack<>();
        System.out.println("Please enter which row");
        r= key.nextInt();
        System.out.println("Please enter which column");
        c= key.nextInt();
    coordinates.push(r);
    coordinates.push(c);
for (int i=0; i<arr.length;i++){

}
    }



    public static void start()
    {
       int[][] arr = floodFillStart();
        display(arr);
    }
    public static void main(String[] args) {
        start();
    }

}
