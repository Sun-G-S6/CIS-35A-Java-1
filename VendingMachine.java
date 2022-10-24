import java.util.Scanner;

public class VendingMachine
{
    public static int chips = 10;
    public static int cookies = 10;
    public static int candies = 10;
    public static double nickle = 0;
    public static double dime = 0;
    public static double quarter = 0;
    public static double dollar = 0;
    public static double change = 0;
    public static void main(String[] args)
    {
        
        System.out.println("Sweet Teeth's V3Nd1NG M4CH1N3\nPlease insert Money");

        menu();

        System.out.println("Thank You, Come Again!");
    }
    //
    //
    //
    public static void menu() 
    {
        int x = 0;

        Scanner moneyIn = new Scanner(System.in);
        
        System.out.println("Press 1 to insert Nickles");
        System.out.println("Press 2 to insert Dimes");
        System.out.println("Press 3 to insert Quarters");
        System.out.println("Press 4 to insert Dollars");
        System.out.println("Press 5 to view food");
        System.out.println("Press 6 for refund");
        System.out.println("Press 7 to exit");

        x = moneyIn.nextInt();


        if (x == 1)
        {
            System.out.println("Enter the amount of nickles.");
            VendingMachine.nickle += moneyIn.nextInt();
            VendingMachine.change = totalChange(VendingMachine.nickle, VendingMachine.dime, VendingMachine.quarter, VendingMachine.dollar);
            printChange(VendingMachine.nickle, VendingMachine.dime, VendingMachine.quarter, VendingMachine.dollar);
            menu();
        }
        if (x == 2)
        {
            System.out.println("Enter the amount of dimes");
            VendingMachine.dime += moneyIn.nextInt();
            VendingMachine.change = totalChange(VendingMachine.nickle, VendingMachine.dime, VendingMachine.quarter, VendingMachine.dollar);
            printChange(VendingMachine.nickle, VendingMachine.dime, VendingMachine.quarter, VendingMachine.dollar);
            menu();
        }
        if (x == 3)
        {
            System.out.println("Enter the amount of quarters.");
            VendingMachine.quarter += moneyIn.nextInt();
            VendingMachine.change = totalChange(VendingMachine.nickle, VendingMachine.dime, VendingMachine.quarter,VendingMachine.dollar);
            printChange(VendingMachine.nickle, VendingMachine.dime, VendingMachine.quarter, VendingMachine.dollar);
            menu();
        }
        if (x == 4)
        {
            System.out.println("Enter the amount of dollars.");
            VendingMachine.dollar += moneyIn.nextInt();
            VendingMachine.change = totalChange(VendingMachine.nickle, VendingMachine.dime, VendingMachine.quarter, VendingMachine.dollar);
            printChange(VendingMachine.nickle, VendingMachine.dime, VendingMachine.quarter, VendingMachine.dollar);
            menu();
        }
        if (x == 5)
        {
            askMenu(VendingMachine.change);
        }
        if (x == 6)
        {
            System.out.println("Here's your change ");
            VendingMachine.change = totalChange(VendingMachine.nickle, VendingMachine.dime, VendingMachine.quarter, VendingMachine.dollar);
            System.out.println("$ "+ VendingMachine.change);
            VendingMachine.nickle = 0;
            VendingMachine.dime = 0;
            VendingMachine.quarter = 0;
            VendingMachine.change = 0;
        }

        moneyIn.close();
    }


    public static void foodMenu() {
        System.out.println("Press 1 for Potato Chips ($1.25)");
        System.out.println("Press 2 for Cookies ($0.85)");
        System.out.println("Press 3 for Candies ($0.95)");
    }


    public static void askMenu(double x)
    {
        double change = x;
        int choice = 0;
        Scanner foodChoice = new Scanner(System.in);
        foodMenu();
        choice = foodChoice.nextInt();

        while (choice < 1 && choice > 3)
        {
            System.out.println("Choice does not exist, try again");
            askMenu(change);
        }

        if (choice == 1 && VendingMachine.chips > 0 && VendingMachine.change > 1.25)
        {
            --VendingMachine.chips;
            VendingMachine.change = VendingMachine.change - 1.25;
            change = change - 1.25;
            System.out.println("Dispensing Potato Chips, Enjoy.");
            System.out.println(VendingMachine.chips + " Remaining.");
        }
        else if (choice == 1 && VendingMachine.chips < 1 && VendingMachine.change < 1.25)
        {
            System.out.println(VendingMachine.change + " change remaining");
            System.out.println("There are no more Potato Chips, choose another item");
            askMenu(change);
        }

        if (choice == 2 && VendingMachine.cookies > 0 && VendingMachine.change > 0.85)
        {
            --VendingMachine.cookies;
            change = change - 0.85;
            System.out.println("Dispensing Cookies, Enjoy.");
            System.out.println(VendingMachine.cookies + " Remaining.");
        }
        else if (choice == 2 && VendingMachine.cookies < 1 && VendingMachine.change < 0.85)
        {
            System.out.println(VendingMachine.change + " change remaining");
            System.out.println("There are no more Cookies, choose another item");
            askMenu(change);
        }

        if (choice == 3 && VendingMachine.candies > 0 && VendingMachine.change > 0.95)
        {
            --VendingMachine.candies;
            change = change - 0.95;
            System.out.println("Dispensing Candies, Enjoy.");
            System.out.println(VendingMachine.candies + " Remaining.");
        }
        else if (choice == 3 && VendingMachine.candies < 1 && VendingMachine.change < 0.95)
        {
            System.out.println(VendingMachine.change + " change remaining");
            System.out.println("There are no more Candies, choose another item");
            askMenu(change);
        }

        System.out.println("Would you like to make another purchase? Please press '4' for yes and '5' for no");
        choice = foodChoice.nextInt();

        if (choice == 4 )
        {
            askMenu(change);
        }
        foodChoice.close();
    }

    public static double totalChange(double nickle, double dime, double quarter, double dollar)
    {
        nickle = nickle*0.05;
        dime = dime*0.10;
        quarter = quarter*0.25;
        
        double change = nickle + dime + quarter + dollar;
        VendingMachine.change = change;
        return change;
    }

    public static void printChange(double nickle, double dime, double quarter, double dollar)
    {
        System.out.println("You've inserted "+nickle+" nickle(s) "+dime+" dime(s) "+quarter+" quarter(s) "+dollar+" dollar(s) ");
    }

}