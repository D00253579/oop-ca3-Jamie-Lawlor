import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Jamie Lawlor
 *  Class Group: SD2B
 */
/*
Direction enum used to indicate direction.
 */
enum DIRECTION {NORTH, SOUTH,EAST,WEST};
public class CA3_Question9
{
    public static class Maze{
int row;
int column;

        public Maze(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

    }

    public static void display(int[][] image)
    {
        //0-7
        for (int x = 0; x < image.length; x++)
        {
            for (int y = 0; y < image.length; y++)
            {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }
    public static void solve(int x, int y, DIRECTION dir)
    {
        Stack<Maze>paths=new Stack<>();
        ArrayList<Maze>Intersections=new ArrayList<>();
        Scanner key=new Scanner(System.in);
        System.out.println("Starting point: 3,4");
        paths.push(new Maze(x,y));
        Intersections.add(new Maze(1,4));
        Intersections.add(new Maze(5,4));
        while(!paths.isEmpty()) {
            System.out.println("Select which direction you would like to take (North, South, East, West): ");
            String choice=key.next();
            if (choice.equalsIgnoreCase("North")){
             dir=DIRECTION.NORTH;
            }else if (choice.equalsIgnoreCase("East")){
                dir=DIRECTION.EAST;
            }else if (choice.equalsIgnoreCase("West")){
             dir=DIRECTION.WEST;
            }else if (choice.equalsIgnoreCase("South")){
                dir=DIRECTION.SOUTH;
            }

            if (dir==DIRECTION.NORTH) {
                paths.pop();
                //North
                paths.push(new Maze(x - 2, y));
                if (Intersections.get(0).getRow()==paths.peek().getRow() && Intersections.get(0).getColumn()==paths.peek().getColumn()){
                    int[][]array={{paths.peek().getRow()},{paths.peek().getColumn()}};

                    System.out.println("You have arrived at an intersection, which path would you like to take: (West, East)");
                    choice=key.next();
                    if (choice.equalsIgnoreCase("North")){
                        dir=DIRECTION.NORTH;
                    }else if (choice.equalsIgnoreCase("East")){
                        dir=DIRECTION.EAST;
                    }else if (choice.equalsIgnoreCase("West")){
                        dir=DIRECTION.WEST;
                    }else if (choice.equalsIgnoreCase("South")){
                        dir=DIRECTION.SOUTH;
                    }
                    if (dir==DIRECTION.NORTH){
                        System.out.println("================WALL================\n");
                    }else if (dir== DIRECTION.EAST || dir==DIRECTION.WEST){
                        System.out.println("DEAD END");
                        System.out.println("Backtracking to starting point\n");
                        paths.pop();
                        paths.push(new Maze(3,4));
                        //Setting direction back to north so it returns to starting point
                        dir=DIRECTION.NORTH;
                    }else if (dir==DIRECTION.SOUTH){
                        System.out.println("You should probably check the paths out first\n");
                    dir=DIRECTION.NORTH;
                    }else{
                        System.out.println("Invalid input");
                    }
                }
            }
            if (dir==DIRECTION.EAST) {
                paths.pop();
                //East
                paths.push(new Maze(x, y + 2));
                System.out.println("DEAD END");
                paths.pop();
                paths.push(new Maze(3,4));
            }
            if (dir==DIRECTION.SOUTH) {
                paths.pop();
                //South
                paths.push(new Maze(x + 2, y));
                if (Intersections.get(1).getRow()==paths.peek().getRow() && Intersections.get(1).getColumn()==paths.peek().getColumn()) {
                    System.out.println("You have arrived at an intersection, which path would you like to take: (South, West)");
                    choice=key.next();
                    if (choice.equalsIgnoreCase("North")){
                        dir=DIRECTION.NORTH;
                    }else if (choice.equalsIgnoreCase("East")){
                        dir=DIRECTION.EAST;
                    }else if (choice.equalsIgnoreCase("West")){
                        dir=DIRECTION.WEST;
                    }else if (choice.equalsIgnoreCase("South")){
                        dir=DIRECTION.SOUTH;
                    }
                    if (dir==DIRECTION.NORTH){
                        System.out.println("You should probably check the paths out first");
                    }else if (dir==DIRECTION.SOUTH || dir== DIRECTION.WEST){
                        System.out.println("DEAD END");
                        System.out.println("Backtracking to starting point\n");
                        paths.pop();
                        paths.push(new Maze(3,4));
                        dir=DIRECTION.SOUTH;
                    }else if (dir==DIRECTION.EAST){
                        System.out.println("================WALL================\n");
                    }
                }
            }
            if (dir==DIRECTION.WEST) {
                paths.pop();
                //West
                paths.push(new Maze(x, y - 2));
                System.out.println("YOU FOUND THE EXIT: CONGRATULATIONS!!!");
                break;
            }

        }


    }
    public static void main(String[] args) {
    solve(3,4,DIRECTION.NORTH);
    int[][]maze=new int[8][8];
    display(maze);
    }

}
