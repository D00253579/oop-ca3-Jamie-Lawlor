import java.util.*;

/**
 * Name: Jamie Lawlor
 * Class Group: SD2B
 */
public class CA3_Question7 {
    //Creating block class to store the quantity and price
    public static class Block {
        int quantity;
        double price;

        public Block(int quantity, double price) {
            this.quantity = quantity;
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }

    }

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String command;
        //Creating the queue
        Queue<Block> shares = new LinkedList<>();
        //Creating the companies map
        Map<String, Queue<Block>> companies = new HashMap<>();
        do {
            System.out.println("============STOCK SHARES============");
            System.out.println("Buy");
            System.out.println("Sell");
            System.out.println("Quit");
            command = in.next();
            if (command.equalsIgnoreCase("buy")) {
                System.out.println("Which company would you like to access?: ");
                String company = in.next();
                System.out.println("How many shares do you wish to buy: ");
                int qty = in.nextInt();
                System.out.println("At what price are they being bought at: ");
                double price = in.nextDouble();
                //Takes in user input and adds a new instance of the class using the user input to the queue.
                Block sharesBought = new Block(qty, price);
                //In this case shares queue will store all shares the user has in the queue
                shares.add(sharesBought);
                //Creating another queue to ensure the queues are individual and don't override each other
                Queue<Block> companyShares = new LinkedList<>();
                companyShares.add(sharesBought);
                //Adds the userInput and the company queue to the map
                companies.put(company, companyShares);
                System.out.println("Shares purchased successfully");
            } else if (command.equals("sell")) {
                System.out.println("Which company would you like to access?: ");
                String company = in.next();

                //Validation if user tries to sell stock more than once
                if (companies.get(company) != null) {
                    //Gets which queue the user wants based on the key the user inputted
                    Block firstBatchOfShares = companies.get(company).peek();
                    System.out.println(" Quantity: " + firstBatchOfShares.getQuantity() + " Price: " + firstBatchOfShares.getPrice());
                    //Checks if user has any shares purchased
                    if (!shares.isEmpty()) {
                        System.out.println("How many shares do you wish to sell?: ");
                        int qty = in.nextInt();
                        //Checking if the user inputted a valid number
                        if (qty > 0) {
                            System.out.println("At what price are you selling them for?");
                            double price = in.nextDouble();
                            double firstBatchBeingSold;
                            double secondBatchBeingSold;
                            double gainFromFirstBatch;
                            double gainFromSecondBatch;
                            double totalGain;
                            //If the user is selling shares from separate batches
                            if (qty > firstBatchOfShares.getQuantity()) {
                                //Storing the first batch and then removing it from the queue
                                firstBatchBeingSold = firstBatchOfShares.getQuantity() * price;
                                shares.remove();
                                //Getting the second values in the second batch
                                Block secondBatchOfShares = companies.get(company).peek();
                                if (secondBatchOfShares != null) {
                                /*Subtracting the amount of shares in the second batch from the amount of shares the user
                                wished to sell - the amount of shares in the first batch
                                This gives the remaining amount of shares the user has
                                */
                                    int remainingShares = secondBatchOfShares.getQuantity() - (qty - firstBatchOfShares.getQuantity());
                                    //Finding how many extra shares the user is selling after the first batch was accounted for
                                    secondBatchBeingSold = (secondBatchOfShares.getQuantity() - remainingShares) * price;
                                    //Adding the remaining shares to the queue and removing the second batch
                                    shares.add(new Block(remainingShares, secondBatchOfShares.getPrice()));
                                    shares.remove();
                                /*Subtracting the amount the user is getting from selling the first batch,
                                from the amount the user paid to get the shares, to get the profit that was made.*/
                                    gainFromFirstBatch = firstBatchBeingSold - (firstBatchOfShares.getQuantity() * firstBatchOfShares.getPrice());
                                /*Subtracting the amount the user paid to get the shares,
                                from the amount of the second batch the user is selling, to get the profit that was made.*/
                                    gainFromSecondBatch = (secondBatchOfShares.getQuantity() * secondBatchOfShares.getPrice()) - secondBatchBeingSold;
                                    //Adding the profit from the first batch with the profit from the second batch to get the total profit.
                                    totalGain = gainFromFirstBatch + gainFromSecondBatch;
                                    System.out.println("Your total profit is: " + totalGain);
                                } else {
                                    System.out.println("Invalid amount of shares\n");
                                }
                            } else {
                                //If the user is selling only one batch
                                totalGain = (qty * price) - firstBatchOfShares.getQuantity() * firstBatchOfShares.getPrice();
                                shares.remove();
                                //Removes the stock from the map
                                companies.remove(company);
                                System.out.println("Your total profit is: " + totalGain);
                            }
                        } else {
                            //Validation for if the user tries to sell more shares than they have bought.
                            System.out.println("\nInvalid amount of shares\n");
                        }
                    } else {
                        //Validation for if the user tries to sell without having bought any shares.
                        System.out.println("\nYou have nothing to sell\n");
                    }
                } else {
                    System.out.println("\nYou have nothing to sell\n");
                }
            } else if (!command.equalsIgnoreCase("quit")) {
                //Validation for correct input
                System.out.println("\nINVALID STATEMENT\n");
            }
            //Exits the program.
        } while (!command.equalsIgnoreCase("quit"));
    }
}
