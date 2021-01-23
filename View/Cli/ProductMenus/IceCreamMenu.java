package View.Cli.ProductMenus;

import View.InputOutput;
import products.Product;
import products.iceCream.IceCream;
import products.iceCream.PlasticCup;
import products.iceCream.WaffleCone;
import products.iceCream.iceCreamFlavors.BananaIceCream;
import products.iceCream.iceCreamFlavors.MintIceCream;
import products.iceCream.iceCreamFlavors.VanillaIceCream;

public class IceCreamMenu implements ProductCliMenu {

    private boolean addAnotherFlavor = true;
    private IceCream iceCream;
    private InputOutput inputOutput;
    public IceCreamMenu(InputOutput ioHandler) {
        this.inputOutput = ioHandler;
    }

    @Override
    public Product displayMenu() {
        
        int numberChoice, numberChoice2;
        
        inputOutput.clearDisplay();
        inputOutput.display("what Ice Cream do you want?");
        inputOutput.display("1. in a plastic cup.");
        inputOutput.display("2. in a waffle cone.");
        inputOutput.display("The default is a cup if you choose other number");
        inputOutput.display("");
        inputOutput.display("please enter the number of your choice...");

        numberChoice = inputOutput.inputInt();

        if(numberChoice == 1){
            iceCream = new PlasticCup();
        }else if(numberChoice == 2){
            iceCream = new WaffleCone();
        }

        inputOutput.clearDisplay();

        inputOutput.display("Great! lets choose the flavors for your Ice Cream now.");
        inputOutput.display("Press any key to continue..");
        inputOutput.inputLine();

        do {
            inputOutput.clearDisplay();
            inputOutput.display("what flavor do you want to add?");

            inputOutput.display("1. Vanilla Flavor");
            inputOutput.display("2. Banana Flavor");
            inputOutput.display("3. Mint Flavor");
            inputOutput.display("The default is a vanilla flavor");
            numberChoice = inputOutput.inputInt();

            inputOutput.clearDisplay();
            inputOutput.display("You chose option " + numberChoice);

            inputOutput.display("");
            inputOutput.display("How many scoops do you want?");
            numberChoice2 = inputOutput.inputInt();
            
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

            inputOutput.clearDisplay();

            inputOutput.display("Great! do you want another flavor? ");
            inputOutput.display("1. no");
            inputOutput.display("2. yes");
            inputOutput.display("The default is no if you choose other number");
            numberChoice = inputOutput.inputInt();
            addAnotherFlavor = numberChoice == 2 ? true: false;
            
        } while (addAnotherFlavor);

        inputOutput.clearDisplay();

        inputOutput.display("This is the ice cream we are going to make:");
        inputOutput.display(iceCream.getDescription());
        inputOutput.display("the price is: " + iceCream.getPrice());
        inputOutput.display("do you accept, or you want to cancel the order of this ice cream?");

        inputOutput.display("1. yes, I want this ice cream.");
        inputOutput.display("2. no, cancle this ice cream.");
        numberChoice = inputOutput.inputInt();
        inputOutput.display("You chose option " + numberChoice);

        if(numberChoice == 1)
            return iceCream;
        else return null;

    }
    
}
