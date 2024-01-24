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
                System.out.print("Please enter takeoffSymbols of all planes (Type quit to exit): ");
                planes=towerInput.nextLine();
                takeOff.add(planes);
                System.out.println("\n"+planes+ " is ready for takeoff");
                    System.out.println("Current flight queue: "+takeOff+"\n");

                }while(!planes.equalsIgnoreCase("quit"));

            }else if (choice.equalsIgnoreCase("landing")){
                do{
                    System.out.print("Please enter landingSymbols of all planes (Type quit to exit): ");
                    planes=towerInput.nextLine();
                    landing.add(planes);
                    System.out.println("\n"+planes+ " is ready for landing");
                    System.out.println("Current flight queue: "+landing+"\n");
                }while(!planes.equalsIgnoreCase("quit"));

            }else if (choice.equalsIgnoreCase("next")){

                do {
                    boolean toggle=false;
                    if (!landing.isEmpty()) {
                        System.out.println(landing.peek() + " has landed");
                        landing.remove();
                        System.out.println(landing);
                        toggle=true;
                        if (landing.isEmpty()){
                            System.out.println("All planes have landed successfully!");
                        toggle=true;
                        }
                    }
                    if (!takeOff.isEmpty()){
                        System.out.println(takeOff.peek() + " has taken off");
                    takeOff.remove();
                    System.out.println(takeOff);
                        if (landing.isEmpty()){
                            System.out.println("All planes have taken off successfully!");
                        }
                    }
                    /*Need to make sure landing is prioritised and also that two takeoff's can occur
                    if there are no landings.
                    * */
                }while(!landing.isEmpty() && !takeOff.isEmpty());
            }

        }while(!choice.equalsIgnoreCase("quit"));
    }
}
