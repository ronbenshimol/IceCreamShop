package View.Cli.ProductMenus;

import View.InputOutput;
import View.Cli.CliInputOutput;

public class ConcreteProductMenuFactory implements ProductMenuFactory {

    @Override
    public ProductCliMenu getProductMenu(int choice) {

        InputOutput inputOutput = new CliInputOutput();

        switch (choice) {
            case 1:
                return new IceCreamMenu(inputOutput);
            default:
                return new IceCreamMenu(inputOutput);
        }
    }

}
