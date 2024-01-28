
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 *  Name: Jamie Lawlor
 *  Class Group: SD2B
 */
public class CA3_Question6
{
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
        Queue<Block>shares=new LinkedList<>();
            do {
            System.out.println("============STOCK SHARES============");
                System.out.println("Buy");
                System.out.println("Sell");
                System.out.println("Quit");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                System.out.println("How many shares do you wish to buy: ");
                int qty = in.nextInt();
                System.out.println("At what price are they being bought at: ");
                double price = in.nextDouble();
                Block sharesBought=new Block(qty,price);
                shares.add(sharesBought);
                System.out.println("Shares purchased successfully");
            }
            else if(command.equals("sell")) {
                Block firstBatchOfShares = shares.peek();
                if (!shares.isEmpty()) {
                    System.out.println("How many shares do you wish to sell?: ");
                    int qty = in.nextInt();

                    if (qty > 0) {
                        System.out.println("At what price are you selling them for?");
                        double price = in.nextDouble();
                            double firstBatchBeingSold;
                            double secondBatchBeingSold;
                            double gainFromFirstBatch=0;
                            double gainFromSecondBatch=0;
                            double totalGain=0;
                        if (qty > firstBatchOfShares.getQuantity()){
                            firstBatchBeingSold=firstBatchOfShares.getQuantity() * price;
                            shares.remove();
                            Block secondBatchOfShares=shares.peek();
                            if (secondBatchOfShares!=null) {
                                //Avoiding nullPointerException
                                int remainingShares = secondBatchOfShares.getQuantity() - (qty - firstBatchOfShares.getQuantity());

                                secondBatchBeingSold = (secondBatchOfShares.getQuantity() - remainingShares) * price;
                                //Adding the remaining shares to the queue and removing the second batch
                                shares.add(new Block(remainingShares, secondBatchOfShares.getPrice()));
                                shares.remove();
                                Block e = shares.peek();
                                System.out.println(e.getQuantity());
                                gainFromFirstBatch = firstBatchBeingSold - (firstBatchOfShares.getQuantity() * firstBatchOfShares.getPrice());
                                gainFromSecondBatch = (secondBatchOfShares.getQuantity() * secondBatchOfShares.getPrice()) - secondBatchBeingSold;
                                totalGain = gainFromFirstBatch + gainFromSecondBatch;
                                System.out.println("Your total profit is: " + totalGain);
                            }else{
                                System.out.println("Invalid amount of shares\n");
                            }
                        }else {
                            totalGain = (qty * price) - firstBatchOfShares.getQuantity() * firstBatchOfShares.getPrice();
                            shares.remove();
                            System.out.println("Your total profit is: " + totalGain);
                        }
                    } else{
                        System.out.println("\nInvalid amount of shares\n");
                    }
                }else {
                    System.out.println("\nYou have nothing to sell\n");
                }
            }else if (!command.equalsIgnoreCase("quit")){
                System.out.println("\nINVALID STATEMENT\n");
            }
        }while(!command.equalsIgnoreCase("quit"));
    }
}