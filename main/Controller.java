// package main;

// import java.util.Scanner;

// public class Controller {

//     public static void main(String[] args) {
//         // Declare Variables
//         int numberOfPizzasOrdered;
//         int numberOfCurrentPizza = 1;

//         // Declare input Scanners
//         Scanner numberOfPizzasOrderedScanner = new Scanner(System.in);
//         Scanner scanner = new Scanner(System.in);

//         // Adding a new Order
//         System.out.println("Pizza Order Manager");
//         System.out.println("===================");
//         System.out.println("");
//         System.out.print("Enter number of Pizza Orders: ");
//         numberOfPizzasOrdered = numberOfPizzasOrderedScanner.nextInt();
//         System.out.println("");

//         // declaring a counter
//         int i = 1;

//         // creating a loop to display entry details for pizzas
//         while (i <= numberOfPizzasOrdered) {
//             System.out.println("Enter Details of Pizza Order " + numberOfCurrentPizza + ":");
//             System.out.println("===================");




//             // // Details of the new order
//             // PizzaOrder p1 = new PizzaOrder();
//             // System.out.print("ID: ");
//             // p1.setId(scanner.nextInt());

//             // if (p1.getId() <= 1000) {
//             //     System.out.print("Please enter a number higher than 1000: ");
//             //     p1.setId(scanner.nextInt());
//             // }


//             // scanner.nextLine();
//             // System.out.print("Name: ");
//             // p1.setName(scanner.nextLine());
//             // System.out.print("Phone: ");
//             // p1.setPhoneNumber(scanner.nextLine());
//             // System.out.print("Order: ");
//             // p1.setOrder(scanner.nextLine().trim());
//             // System.out.print("Type (Pick-Up or Delivery): ");
//             // p1.setType(scanner.next());


//             // Display Pizza Order Details
//             System.out.println("");
//             System.out.println("Details of Pizza Order " + numberOfCurrentPizza + ":");
//             System.out.println("=======================");
//             System.out.println("ID: " + p1.getId());
//             System.out.println("Name: " + p1.getName());

//             System.out.println("Phone: " + p1.getPhoneNumber());

//             System.out.println("Order: " + p1.getOrder()); // Type of Pizza eg; Peperoni
//             System.out.println("Type (Pick-up or Delivery): " + p1.getType()); // Pickup or Delivery
//             System.out.println("Pizza Cost ($): " + p1.determinePizzaPrice());
//             // System.out.println("Delivery cost($): " + p1.deliveryCost());
//             System.out.println("Calculate total cost ($): " + p1.totalCost());

//             numberOfCurrentPizza = numberOfCurrentPizza + 1;
//             i++;

//         } // end while

//     }

// }