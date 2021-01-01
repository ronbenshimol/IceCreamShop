package View.Cli.ProductMenus;

import java.util.Scanner;

import products.Product;
import products.iceCream.IceCream;
import products.iceCream.PlasticCup;
import products.iceCream.WaffleCone;
import products.iceCream.iceCreamFlavors.BananaIceCream;
import products.iceCream.iceCreamFlavors.MintIceCream;
import products.iceCream.iceCreamFlavors.VanillaIceCream;

public class IceCreamMenu implements ProductCliMenu {

    private Scanner scanner;
    private boolean addAnotherFlavor = true;
    private IceCream iceCream;
    public IceCreamMenu() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Product displayMenue() {
        
        int numberChoice, numberChoice2;

        System.out.print("\033[H\033[2J");// clear the console

        System.out.println("what Ice Cream do you want?");
        System.out.println("1. in a plastic cup.");
        System.out.println("2. in a waffle cone.");
        System.out.println("The default is a cup if you choose other number");
        System.out.println("");
        System.out.println("please enter the number of your choice...");

        numberChoice = this.scanner.nextInt();

        if(numberChoice == 1){
            iceCream = new PlasticCup();
        }else if(numberChoice == 2){
            iceCream = new WaffleCone();
        }

        System.out.print("\033[H\033[2J");// clear the console

        System.out.println("Great! lets choose the flavors for your Ice Cream now.");
        System.out.println("Press any key to continue..");
        this.scanner.nextLine();

        do {
            System.out.print("\033[H\033[2J");// clear the console
            System.out.println("what flavor do you want to add?");

            System.out.println("1. Vanilla Flavor");
            System.out.println("2. Banana Flavor");
            System.out.println("3. Mint Flavor");
            System.out.println("The default is a vanilla flavor");
            numberChoice = this.scanner.nextInt();

            System.out.print("\033[H\033[2J");// clear the console
            System.out.println("You chose option " + numberChoice);

            System.out.println("");
            System.out.println("How many scoops do you want?");
            numberChoice2 = this.scanner.nextInt();
            
            switch (numberChoice) {
                case 1:
                    iceCream = new VanillaIceCream(iceCream, numberChoice2);
                    break;
                case 2:
                    iceCream = new BananaIceCream(iceCream, numberChoice2);
                    break;
                case 3: 
                    iceCream = new MintIceCream(iceCream, numberChoice2);
                    break;
                default:
                    iceCream = new VanillaIceCream(iceCream, numberChoice2);
                    break;
            }

            System.out.print("\033[H\033[2J");// clear the console

            System.out.println("Great! do you want another flavor? ");
            System.out.println("1. no");
            System.out.println("2. yes");
            System.out.println("The default is no if you choose other number");
            numberChoice = this.scanner.nextInt();
            addAnotherFlavor = numberChoice == 2 ? true: false;
            
        } while (addAnotherFlavor);

        System.out.print("\033[H\033[2J");// clear the console

        System.out.println("This is the ice cream we are going to make:");
        System.out.println(iceCream.getDescription());
        System.out.println("the price is: " + iceCream.getPrice());
        System.out.println("do you accept, or you want to cancel the order of this ice cream?");

        System.out.println("1. yes, I want this ice cream.");
        System.out.println("2. no, cancle this ice cream.");
        numberChoice = this.scanner.nextInt();
        System.out.println("You chose option " + numberChoice);

        if(numberChoice == 1)
            return iceCream;
        else return null;

    }
    
}
