import java.util.Scanner;
import java.util.Stack;

/**
 * Name: Jamie Lawlor
 * Class Group:SD2B
 */
public class CA3_Question1 {
    public static void runSimulation() {
        Stack<Integer> driveway = new Stack<>();
        Stack<Integer> street = new Stack<>();
        //Getting user input.
        Scanner key = new Scanner(System.in);
        //Declaring variables.
        int choice;
        int plateNumber;
        do {
            //Creating menu and allowing user to choose options.
            System.out.println("0: Exit");
            System.out.println("1: Add a car who rented a space");
            System.out.println("2: Remove a car");
            System.out.println("3: View current cars in driveway");
            choice = key.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter the licence plate number of the car");
                    //Takes the user input and pushes to the driveway stack.
                    plateNumber = key.nextInt();
                    driveway.push(plateNumber);
                    System.out.println("Car added to driveway: \n" + driveway + "\n");
                    break;
                }
                case 2: {
                    //Validation for when no cars have been added.
                    if (driveway.isEmpty()) {
                        System.out.println("Driveway is empty\n");
                    } else {
                        System.out.println("Enter the licence plate number of the car to be removed");
                        plateNumber = key.nextInt();
                        //Validation to avoid EmptyStackException.
                        if (driveway.size() == 1) {
                            driveway.pop();
                            System.out.println("Driveway is empty");
                            //-driveway.peek to ensure that only negative numbers will be read.
                        } else if (-driveway.peek() == plateNumber) {
                            driveway.pop();
                        } else {
                            //When the car requested is not at the top of the stack.
                            while (-driveway.peek() != plateNumber) {
                                street.push(driveway.peek());
                                driveway.pop();
                            }
                            driveway.pop();
                            //Brings cars that had to move to the street back into the driveway.
                            do {
                                driveway.push(street.peek());
                                street.pop();

                            } while (!street.isEmpty());
                        }
                        System.out.println("Car was removed from driveway: " + driveway + "\n");
                    }

                    break;
                }
                case 3: {
                    //Allows users to view the current cars in the stack.
                    System.out.println("=====CURRENT CARS IN DRIVEWAY====== \n" + driveway + "\n");
                    break;
                }
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
        runSimulation();
    }
}
