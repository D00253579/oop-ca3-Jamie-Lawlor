import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name: Jamie
 *  Class Group: SD2B
 */

public class CA3_Question5
{

    public static void main(String[] args)
    {
        Scanner key = new Scanner(System.in);
        //Declaring variables.
        String choice;
        Queue<String>takeOff=new LinkedList<>();
        Queue<String>landing=new  LinkedList<>();

        do {
            //Creating menu and allowing user to choose options.
            System.out.println("===========FLIGHT COMMAND===========");
            System.out.println("\t\t\ttakeoff");
            System.out.println("\t\t\tlanding");
            System.out.println("\t\t\tNext");
            System.out.println("\t\t\tQuit");
            System.out.print("\nPlease enter your option: ");
            choice = key.nextLine();

            Scanner towerInput=new Scanner(System.in);
            String planes;

            if (choice.equalsIgnoreCase("takeoff")){

                do{
                    //Allows users to input as many flight symbols as they wish
                System.out.print("Please enter takeoffSymbols of all planes (Type quit to exit): ");
                planes=towerInput.nextLine();
                /*Fixes issue for when the user typed 'quit', it was added to the queue as well as
                    breaking out of the loop*/
                if (!planes.equalsIgnoreCase("quit")){
                    takeOff.add(planes);
                    System.out.println("\n"+planes+ " is ready for takeoff");
                    //Displays what's currently in the queue.
                    System.out.println("Current flight queue: "+takeOff+"\n");
                }

                }while(!planes.equalsIgnoreCase("quit"));

            }else if (choice.equalsIgnoreCase("landing")){
                do{
                    System.out.print("Please enter landingSymbols of all planes (Type quit to exit): ");
                    planes=towerInput.nextLine();
                    if (!planes.equalsIgnoreCase("quit")) {
                        landing.add(planes);
                        System.out.println("\n" + planes + " is ready for landing");
                        System.out.println("Current flight queue: " + landing + "\n");
                    }
                }while(!planes.equalsIgnoreCase("quit"));

            }else if (choice.equalsIgnoreCase("next")){

                do {
                    //Prioritises landing first
                    if (!landing.isEmpty()) {
                        System.out.println(landing.peek() + " has landed");
                        landing.remove();
                        System.out.println(landing);

                        if (landing.isEmpty()){
                            System.out.println("All planes have landed successfully!");

                        }
                    }
                    /* Enables the next prioritised flight, if they are none to takeoff
                    then repeats the landing statement until both queues are empty.
                     */
                    if (!takeOff.isEmpty()){
                        System.out.println(takeOff.peek() + " has taken off");
                    takeOff.remove();
                    System.out.println(takeOff);
                        if (takeOff.isEmpty()){
                            System.out.println("All planes have taken off successfully!");
                        }
                    }
                   
                }while(!landing.isEmpty() || !takeOff.isEmpty());
            }
        //Exits the program
        }while(!choice.equalsIgnoreCase("quit"));
    }
}
