import java.util.Scanner;
import java.util.Stack;

/**
 * Name: Jamie Lawlor
 * Class Group: SD2B
 */


public class CA3_Question2 {
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
        Starter function to create the 2D array and populate it with 0

     */

    public static int[][] floodFillStart() {
        Scanner kb = new Scanner(System.in);
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                arr[x][y] = 0;
            }
        }
        return arr;
    }

    /*
        Helper function to display the image
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
        Stack<Pair> coordinates = new Stack<>();
        Pair p1 = new Pair(r, c);
        coordinates.push(p1);
        Pair peekCoordinates = coordinates.peek();
        do {
            coordinates.pop();
            int order = 0;
            order++;
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 10; y++) {
                    if (arr[x][y] == 0) {
                        arr[x][y] = order++;
                        if (x-1>=0 && arr[x - 1][y] == 0) {
                            coordinates.push(new Pair(x - 1, y));
                        } else if (x+1<10 && arr[x + 1][y] == 0) {
                            coordinates.push(new Pair(x + 1, y));
                        } else if (y-1>=0 && arr[x][y - 1] == 0) {
                            coordinates.push(new Pair(x, y - 1));
                        } else if (y+1<10 && arr[x][y + 1] == 0) {
                            coordinates.push(new Pair(x, y + 1));
                        }
                        System.out.println("Arr: " + peekCoordinates.getRow()+", "+peekCoordinates.getColumn());


                    }

                }
            }
        } while (!coordinates.isEmpty());
//        Pair peekedPair=coordinates.peek();
//        System.out.println("YOOOOO:("+peekedPair.getRow()+", "+peekedPair.getColumn()+")");

    }
    public static void start() {
        int[][] arr = floodFillStart();
        Scanner key = new Scanner(System.in);
        System.out.println("Please enter which row");
        int r = key.nextInt();
        System.out.println("Please enter which column");
        int c = key.nextInt();
        fill(r, c, arr);
        display(arr);
    }

    public static void main(String[] args){
                start();
            }
    }
