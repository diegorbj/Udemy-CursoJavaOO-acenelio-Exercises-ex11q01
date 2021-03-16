package aplication;

import entities.*;
import entities.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.nextLine());

        System.out.println("Enter order data:");
        System.out.print("Status: ");

        Order order = new Order(OrderStatus.valueOf(sc.nextLine()), new Client(name, email, birthDate));

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            sc.nextLine();
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            Integer productQuantity = sc.nextInt();
            order.addOrderItem(new OrderItem(new Product(productName, productPrice), productQuantity, productPrice));
        }

        System.out.println(order);

        sc.close();
    }
}
