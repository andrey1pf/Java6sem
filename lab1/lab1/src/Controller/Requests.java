package Controller;

import DAOs.CustomerDAO;
import DAOs.OrdersDAO;
import DAOs.ServiceDAO;
import DAOs.WorkersDAO;

import java.util.Scanner;

public class Requests {
    private static void oneCustomerManyTasks(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer id: " );
        int id = Integer.parseInt(scanner.next());

        OrdersDAO order = new OrdersDAO();
        System.out.println(order.getAllById(id));
    }

    private static void oneServiceOneOrders(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter order id: " );
        int id = Integer.parseInt(scanner.next());

        ServiceDAO service = new ServiceDAO();
        System.out.println(service.getService(id));
    }

    private static void addWorker(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter worker id: " );
        int id = Integer.parseInt(scanner.next());
        System.out.println("0 or 1: ");
        int emp = Integer.parseInt(scanner.next());

        WorkersDAO worker = new WorkersDAO();
        worker.updateWorker(emp, id);
    }

    private static void selectNoPaidOrders(){
        OrdersDAO orders = new OrdersDAO();
        System.out.println(orders.getNoPaidOrders());
    }

    private static void Menu(){
        System.out.println("Enter action number");
        System.out.println("[+] 1. Display information about all tasks of the specified customer.");
        System.out.println("[+] 2. Display information about the required specialists of the specified job.");
        System.out.println("[+] 3. Assign workers to the project.");
        System.out.println("[+] 4. Display information about unpaid projects.");
        System.out.println("[-] 5. Exit");
    }
    public void Start(){
        String exit = "";
        while (!exit.equals("5")){
            Menu();
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine()) {
                case "1" -> oneCustomerManyTasks();
                case "2" -> oneServiceOneOrders();
                case "3" -> addWorker();
                case "4" -> selectNoPaidOrders();
                case "5" -> {
                    exit = "5";
                }
            }
        }
    }
}
