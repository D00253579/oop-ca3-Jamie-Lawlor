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
        Scanner key = new Scanner(System.in);
        int choice = 0;
        int plateNumber = 0;
        do {
            System.out.println("0: Exit");
            System.out.println("1: Add a car who rented a space");
            System.out.println("2: Remove a car");
            System.out.println("3: View current cars in driveway");
            choice = key.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter the licence plate number of the car");
                    plateNumber = key.nextInt();
                    driveway.push(plateNumber);
                    System.out.println("Car added to driveway: \n" + driveway + "\n");

                    break;
                }
                case 2: {
                    if (driveway.isEmpty()) {
                        System.out.println("Driveway is empty\n");
                    } else {
                        System.out.println("Enter the licence plate number of the car to be removed");
                        plateNumber = key.nextInt();
                        if (driveway.size() == 1) {
                            driveway.pop();
                            System.out.println("Driveway is empty");
                        } else if (-driveway.peek()==plateNumber){
                            driveway.pop();
                        }else {
                            while (-driveway.peek() != plateNumber) {
                                street.push(driveway.peek());
                                driveway.pop();
                            }
                           driveway.pop();
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
