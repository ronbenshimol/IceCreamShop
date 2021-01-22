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
    public Product displayMenue() {
        
        int numberChoice, numberChoice2;
        
        inputOutput.clearDisplay();
        inputOutput.diplay("what Ice Cream do you want?");
        inputOutput.diplay("1. in a plastic cup.");
        inputOutput.diplay("2. in a waffle cone.");
        inputOutput.diplay("The default is a cup if you choose other number");
        inputOutput.diplay("");
        inputOutput.diplay("please enter the number of your choice...");

        numberChoice = inputOutput.inputInt();

        if(numberChoice == 1){
            iceCream = new PlasticCup();
        }else if(numberChoice == 2){
            iceCream = new WaffleCone();
        }

        inputOutput.clearDisplay();

        inputOutput.diplay("Great! lets choose the flavors for your Ice Cream now.");
        inputOutput.diplay("Press any key to continue..");
        inputOutput.inputLine();

        do {
            inputOutput.clearDisplay();
            inputOutput.diplay("what flavor do you want to add?");

            inputOutput.diplay("1. Vanilla Flavor");
            inputOutput.diplay("2. Banana Flavor");
            inputOutput.diplay("3. Mint Flavor");
            inputOutput.diplay("The default is a vanilla flavor");
            numberChoice = inputOutput.inputInt();

            inputOutput.clearDisplay();
            inputOutput.diplay("You chose option " + numberChoice);

            inputOutput.diplay("");
            inputOutput.diplay("How many scoops do you want?");
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

            inputOutput.diplay("Great! do you want another flavor? ");
            inputOutput.diplay("1. no");
            inputOutput.diplay("2. yes");
            inputOutput.diplay("The default is no if you choose other number");
            numberChoice = inputOutput.inputInt();
            addAnotherFlavor = numberChoice == 2 ? true: false;
            
        } while (addAnotherFlavor);

        inputOutput.clearDisplay();

        inputOutput.diplay("This is the ice cream we are going to make:");
        inputOutput.diplay(iceCream.getDescription());
        inputOutput.diplay("the price is: " + iceCream.getPrice());
        inputOutput.diplay("do you accept, or you want to cancel the order of this ice cream?");

        inputOutput.diplay("1. yes, I want this ice cream.");
        inputOutput.diplay("2. no, cancle this ice cream.");
        numberChoice = inputOutput.inputInt();
        inputOutput.diplay("You chose option " + numberChoice);

        if(numberChoice == 1)
            return iceCream;
        else return null;

    }
    
}
