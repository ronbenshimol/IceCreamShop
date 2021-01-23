package View.Cli;

import java.util.Scanner;

import View.InputOutput;

public class CliInputOutput implements InputOutput {
    private Scanner scanner;

    public CliInputOutput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void display(String output) {
        System.out.println(output);
    }

    @Override
    public int inputInt() {
        return this.scanner.nextInt();
    }

    @Override
    public String inputLine() {
        return this.scanner.nextLine();
    }

    @Override
    public void clearDisplay() {
        System.out.print("\033[H\033[2J");// clear the console
    }

}
