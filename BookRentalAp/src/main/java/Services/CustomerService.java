package Services;

import java.util.Scanner;

import DAO.dbOperations;
import Models.Customer;

public class CustomerService {
    Customer customer;
    dbOperations dbOp;

    public CustomerService(){
    }

    @SuppressWarnings("resource")
	public void addCustomer(Scanner sc){

        sc = new Scanner(System.in);
        customer = new Customer();
        dbOp = new dbOperations();

        System.out.println("Enter customer Id");
        int customerId = sc.nextInt();
        System.out.println("Enter first name ");
        String firstName = sc.nextLine();
        System.out.println("Enter last name ");
        String lastName = sc.nextLine();

        customer.setCustomerId(customerId);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        boolean result = dbOp.addCustomer(customer);
        System.out.println(" You added "+firstName+" "+lastName+" to the database");
    }


    public void viewCustomer(Scanner sc){
    // Replace book with customer
//        dbOp = new dbOperations();
//        System.out.println("Enter Book Title ");
//        String bkTitle = sc.nextLine();
//        dbOp.viewBookByName(bkTitle);
//        System.out.println();
    }

    public void removeCustomerById(Scanner sc){
        dbOp = new dbOperations();
        System.out.println("Enter Customer ID:");
        int id = sc.nextInt();
        dbOp.DeleteCustomerById(id);
        System.out.println();
    }

    public void viewAllCustomers() {
    	// Print out all customers
    }
}
