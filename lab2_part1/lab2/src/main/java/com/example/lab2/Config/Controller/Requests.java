package com.example.lab2.Config.Controller;

import com.example.lab2.Config.Connection.ConnectionPool;
import com.example.lab2.Config.DAOs.OrdersDAO;
import com.example.lab2.Config.DAOs.ServiceDAO;
import com.example.lab2.Config.DAOs.WorkersDAO;
import com.example.lab2.Config.Exceptions.PoolException;

import java.util.Scanner;

/**
 * Class for control terminal activity
 */
public class Requests {
    /**
     * Method for display information about all tasks of the specified customer
     */
    private static void oneCustomerManyTasks(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer id: " );
        int id = Integer.parseInt(scanner.next());

        OrdersDAO order = new OrdersDAO();
        var result = order.getAllById(id);

        for (int i = 0; i < result.size(); ++i){
            System.out.println("ID: " + result.get(i).getId() + ", Customer ID: " + result.get(i).getId_customer() +
                    ", Service ID: " + result.get(i).getId_task() + ", Price: " + result.get(i).getPrice() + ", Paid: "
                    + result.get(i).getPaid());
        }
    }

    /**
     * Method for display information about the required specialists of the specified job
     */
    private static void oneServiceOneOrders(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter service id: " );
        int id = Integer.parseInt(scanner.next());

        ServiceDAO service = new ServiceDAO();
        var res = service.getService(id).get();
        System.out.println("Qualification: " + res.getQualificationService() + ", Amount workers: " + res.getAmountWorkersService());
    }

    /**
     * Method for assign workers to the project
     */

    private static void addWorker(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter worker id: " );
        int id = Integer.parseInt(scanner.next());
        System.out.println("0 or 1: ");
        int emp = Integer.parseInt(scanner.next());

        WorkersDAO worker = new WorkersDAO();
        worker.updateWorker(emp, id);
    }

    /**
     * Method for display information about unpaid projects
     */
    private static void selectNoPaidOrders(){
        OrdersDAO orders = new OrdersDAO();
        var result = orders.getNoPaidOrders();
        for (int i = 0; i < result.size(); ++i){
            System.out.println("ID: " + result.get(i).getId() + ", Customer ID: " + result.get(i).getId_customer() +
                    ", Service ID: " + result.get(i).getId_task() + ", Price: " + result.get(i).getPrice() + ", Paid: "
                    + result.get(i).getPaid());
        }
    }

    private static void Menu(){
        System.out.println("Enter action number");
        System.out.println("[+] 1. Display information about all tasks of the specified customer.");
        System.out.println("[+] 2. Display information about the required specialists of the specified job.");
        System.out.println("[+] 3. Assign workers to the project.");
        System.out.println("[+] 4. Display information about unpaid projects.");
        System.out.println("[-] 5. Exit");
    }
    public void Start() throws PoolException {
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
                    ConnectionPool.closeConnections();
                }
            }
        }
    }
}
